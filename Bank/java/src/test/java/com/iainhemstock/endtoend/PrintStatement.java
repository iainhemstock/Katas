package com.iainhemstock.endtoend;

import com.iainhemstock.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PrintStatement {

    public static final String DB_CONFIG_FILE_PATH = ".dbconfig";

    @Mock private Console console;
    @Mock private Calendar calendar;

    private Account account;

    @Before
    public void setup() {
        deleteAllRowsFromTestDatabase();
        when(calendar.today()).thenReturn("01 Apr 14", "02 Apr 14", "10 Apr 14");
        TransactionRepository transactionRepository = new DatabaseTransactionRepository(DB_CONFIG_FILE_PATH, calendar);
        StatementPrinter statementPrinter = new ConsoleStatementPrinter(console);
        account = new Account(transactionRepository, statementPrinter);
    }

    @Test
    public void should_print_statement_of_all_transactions() {

        account.deposit(new TransactionAmount(1000));
        account.withdraw(new TransactionAmount(123.45));
        account.deposit(new TransactionAmount(510.01));
        account.print();

        InOrder order = inOrder(console);
        order.verify(console).printLine("+ --------------------------------------------------------------------------- +");
        order.verify(console).printLine("| Date      | Payment type and details | Paid out   | Paid in    |    Balance |");
        order.verify(console).printLine("+ --------------------------------------------------------------------------- +");
        order.verify(console).printLine("| 10 Apr 14 | Deposit                  |            | 510.01     |    1386.56 |");
        order.verify(console).printLine("| 02 Apr 14 | Withdrawal               | 123.45     |            |     876.55 |");
        order.verify(console).printLine("| 01 Apr 14 | Deposit                  |            | 1000.00    |    1000.00 |");
        order.verify(console).printLine("+ --------------------------------------------------------------------------- +");
    }

    private void deleteAllRowsFromTestDatabase() {
        try (FileInputStream input = new FileInputStream(DB_CONFIG_FILE_PATH)) {
            Properties properties = new Properties();
            properties.load(input);
            String server = properties.getProperty("dbserver");
            String username = properties.getProperty("dbusername");
            String password = properties.getProperty("dbpassword");

            try (
                    Connection connection = DriverManager.getConnection(server, username, password);
                    Statement statement = connection.createStatement();
            ){
                String table = "transactions";
                String query = String.format("delete from %s", table);
                statement.executeUpdate(query);
            }
            catch (SQLException ex) { ex.printStackTrace(); }
        }
        catch (IOException ex) { ex.printStackTrace(); }
    }

}
