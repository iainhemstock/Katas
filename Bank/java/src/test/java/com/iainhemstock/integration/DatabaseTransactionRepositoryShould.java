package com.iainhemstock.integration;

import com.iainhemstock.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class DatabaseTransactionRepositoryShould {

    public static final String DB_CONFIG_FILEPATH = ".dbconfig";
    private static final String TODAY_dd_MMM_yy_FORMAT = "04 Jul 15";
    public static final String SQL_DELETE_ALL_ROWS_ = "delete from %s";

    @Mock private Calendar calendar;

    private DatabaseTransactionRepository databaseTransactionRepository;
    private TransactionDate transactionDate;
    private TransactionAmount transactionAmount;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        deleteAllRowsFromTestDatabase();
        given(calendar.today()).willReturn(TODAY_dd_MMM_yy_FORMAT);
        databaseTransactionRepository = new DatabaseTransactionRepository(DB_CONFIG_FILEPATH, calendar);
        transactionDate = new TransactionDate(calendar.today());
        transactionAmount = new TransactionAmount(123.45);
    }

    @Test
    public void add_single_deposit_transaction_to_database() {
        databaseTransactionRepository.addDeposit(transactionAmount);
        assertThat(transactionCount(), is(equalTo(1)));
        assertThat(onlyTransaction(), is(equalTo(new Transaction(transactionAmount, transactionDate))));
    }

    @Test
    public void add_single_withdrawal_transaction_to_database() {
        databaseTransactionRepository.addWithdrawal(transactionAmount);
        assertThat(transactionCount(), is(equalTo(1)));
        assertThat(onlyTransaction(), is(equalTo(new Transaction(transactionAmount.negated(), transactionDate))));
    }

    private Transaction onlyTransaction() {
        return databaseTransactionRepository.toList().get(0);
    }

    private int transactionCount() {
        return databaseTransactionRepository.transactionCount();
    }

    private void deleteAllRowsFromTestDatabase() {
        try (FileInputStream input = new FileInputStream(DB_CONFIG_FILEPATH)) {
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
                String query = String.format(SQL_DELETE_ALL_ROWS_, table);
                statement.executeUpdate(query);
            }
            catch (SQLException ex) { ex.printStackTrace(); }
        }
        catch (IOException ex) { ex.printStackTrace(); }
    }

}
