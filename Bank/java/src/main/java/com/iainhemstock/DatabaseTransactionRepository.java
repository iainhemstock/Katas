package com.iainhemstock;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DatabaseTransactionRepository implements TransactionRepository {

    public static final String TRANSACTIONS_TABLE = "transactions";
    public static final String TRANSACTION_AMOUNT_COL = "transaction_amount";
    private static final String TRANSACTION_DATE_COL = "transaction_date";

    private String server;
    private String dbname;
    private String username;
    private String password;
    private Calendar calendar;

    public DatabaseTransactionRepository(String dbConfigFilepath, Calendar calendar) {
        this.calendar = calendar;

        try (FileInputStream input = new FileInputStream(dbConfigFilepath)) {
            Properties properties = new Properties();
            properties.load(input);
            this.server = properties.getProperty("dbserver");
            this.dbname = properties.getProperty("dbname");
            this.username = properties.getProperty("dbusername");
            this.password = properties.getProperty("dbpassword");
        }
        catch (IOException ex) { ex.printStackTrace(); }
    }

    @Override
    public void addDeposit(TransactionAmount amount) {
        TransactionDate today = new TransactionDate(calendar.today());
        Transaction transaction = new Transaction(amount, today);
        addTransaction(transaction);
    }

    @Override
    public void addWithdrawal(TransactionAmount amount) {
        TransactionDate today = new TransactionDate(calendar.today());
        Transaction transaction = new Transaction(amount.negated(), today);
        addTransaction(transaction);
    }

    private void addTransaction(Transaction transaction) {
        String query = String.format(
                "insert into %s (%s, %s) values (%.2f, '%s');",
                TRANSACTIONS_TABLE, TRANSACTION_AMOUNT_COL, TRANSACTION_DATE_COL,
                transaction.amount().toDouble(), transaction.date().toString()
        );

        try (
                Connection connection = DriverManager.getConnection(server, username, password);
                Statement statement = connection.createStatement();
        ){
            statement.executeUpdate(query);
        }
        catch (SQLException ex) { ex.printStackTrace(); }
    }

    @Override
    public List<Transaction> toList() {
        List<Transaction> allTransactions = new ArrayList();
        String query = String.format(
                "select * from %s order by id ASC",
                TRANSACTIONS_TABLE
        );
        try (
                Connection connection = DriverManager.getConnection(server, username, password);
                Statement statement = connection.createStatement();
                ResultSet results = statement.executeQuery(query);
        ){
            addTransactionsFromResultSetToList(allTransactions, results);
        }
        catch (SQLException ex) { ex.printStackTrace(); }

        return allTransactions;
    }

    @Override
    public int transactionCount() {
        return toList().size();
    }

    private void addTransactionsFromResultSetToList(List<Transaction> allTransactions, ResultSet results) {
        try {
            while (results.next()) {
                double amount = results.getDouble(TRANSACTION_AMOUNT_COL);
                String date = results.getString(TRANSACTION_DATE_COL);
                Transaction transaction = new Transaction(new TransactionAmount(amount), new TransactionDate(date));
                allTransactions.add(transaction);
            }
        }
        catch (SQLException ex) { ex.printStackTrace(); }
    }


}
