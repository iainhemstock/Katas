package com.iainhemstock.integration;

import com.iainhemstock.*;
import org.junit.Before;
import org.junit.Test;

import java.sql.*;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class DatabaseTransactionRepositoryShould {

    private String server = "jdbc:mysql://localhost:8889/test_bank";
    private String username = "root";
    private String password = "root";

    private Calendar calendar = mock(Calendar.class);
    private static final String TODAY = "04 Jul 15";

    private DatabaseTransactionRepository databaseTransactionRepository;
    private TransactionDate today;
    private TransactionAmount amount;

    @Before
    public void setup() {
        deleteAllRowsFromTestDatabase();
        given(calendar.today()).willReturn(TODAY);
        databaseTransactionRepository = new DatabaseTransactionRepository(server, username, password, calendar);
        today = new TransactionDate(calendar.today());
        amount = new TransactionAmount(123.45);
    }

    @Test
    public void add_single_deposit_transaction_to_database() {
        databaseTransactionRepository.addDeposit(amount);
        assertThat(transactionCount(), is(equalTo(1)));
        assertThat(onlyTransaction(), is(equalTo(new Transaction(amount, today))));
    }

    @Test
    public void add_single_withdrawal_transaction_to_database() {
        databaseTransactionRepository.addWithdrawal(amount);
        assertThat(transactionCount(), is(equalTo(1)));
        assertThat(onlyTransaction(), is(equalTo(new Transaction(amount.negated(), today))));
    }

    private Transaction onlyTransaction() {
        return databaseTransactionRepository.toList().get(0);
    }

    private int transactionCount() {
        return databaseTransactionRepository.transactionCount();
    }

    public void deleteAllRowsFromTestDatabase() {
        try {
            Connection connection = DriverManager.getConnection(server, username, password);
            Statement statement = connection.createStatement();
            String table = "transactions";
            String query = String.format("delete from %s", table);
            statement.executeUpdate(query);
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
