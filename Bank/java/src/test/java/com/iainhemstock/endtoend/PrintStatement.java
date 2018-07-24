package com.iainhemstock.endtoend;

import com.iainhemstock.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class PrintStatement {

    public static final String JDBC_MYSQL_LOCALHOST_8889_BANK = "jdbc:mysql://localhost:8889/test_bank";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "root";
    private Console console;
    private Account account;
    private Calendar calendar;

    @Before
    public void setup() {
        calendar = new Calendar();
        TransactionRepository transactionRepository = new DatabaseTransactionRepository(
                JDBC_MYSQL_LOCALHOST_8889_BANK, USERNAME, PASSWORD, calendar);
        console = mock(Console.class);
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
        order.verify(console).printLine("+ ------------------------------------------------------------------------- +");
        order.verify(console).printLine("| Date      | Payment type and details | Paid out   | Paid in   |   Balance |");
        order.verify(console).printLine("+ ------------------------------------------------------------------------- +");
        order.verify(console).printLine("| 10 Apr 14 | Deposit                  |            |    510.01 |   1386.56 |");
        order.verify(console).printLine("| 02 Apr 14 | Withdrawal               |     123.45 |           |    876.55 |");
        order.verify(console).printLine("| 01 Apr 14 | Deposit                  |            |   1000.00 |   1000.00 |");
        order.verify(console).printLine("+ ------------------------------------------------------------------------- +");
    }

}
