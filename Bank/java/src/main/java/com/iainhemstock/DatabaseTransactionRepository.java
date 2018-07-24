package com.iainhemstock;

import java.sql.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class DatabaseTransactionRepository implements TransactionRepository {

    public static final String TRANSACTIONS_TABLE = "transactions";
    public static final String TRANSACTION_AMOUNT_COL = "transaction_amount";
    public static final String DECIMAL_FORMAT_PATTERN_2_DECIMAL_PLACES = "#.##";
    private Statement statement;
    private DecimalFormat decimalFormat = new DecimalFormat(DECIMAL_FORMAT_PATTERN_2_DECIMAL_PLACES);
    private Calendar calendar;

    public DatabaseTransactionRepository(String server, String username, String password, Calendar calendar) {
        this.calendar = calendar;
        try {
            Connection connection = connectToDatabase(server, username, password);
            statement = connection.createStatement();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private Connection connectToDatabase(String server, String username, String password) throws SQLException {
        return DriverManager.getConnection(server, username, password);
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

    @Override
    public List<Transaction> toList() {
        ResultSet results = executeQuery(String.format(
                "select %s from %s",
                TRANSACTION_AMOUNT_COL, TRANSACTIONS_TABLE)
        );

        return populateListWithResults(results);
    }

    private void addTransaction(Transaction transaction) {
        String query = String.format(
                "insert into %s (%s) values (%.2f)",
                TRANSACTIONS_TABLE, TRANSACTION_AMOUNT_COL, transaction.amount().toDouble());
        try { statement.executeUpdate(query); }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private ResultSet executeQuery(String query) {
        ResultSet results = null;
        try { results = statement.executeQuery(query); }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return results;
    }

    private List<Transaction> populateListWithResults(ResultSet results) {
        List<Transaction> allTransactions = new ArrayList();
        try {
            while (results.next()) {
                double amount = results.getDouble(TRANSACTION_AMOUNT_COL);
                TransactionAmount transactionAmount = new TransactionAmount(amount);
                TransactionDate today = new TransactionDate(calendar.today());
                Transaction transaction = new Transaction(transactionAmount, today);
                allTransactions.add(transaction);
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return allTransactions;
    }

    @Override
    public int transactionCount() {
        return toList().size();
    }


}
