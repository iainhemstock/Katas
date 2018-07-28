package com.iainhemstock;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class App 
{
    public static void main( String[] args ) {
        String dbConfigFilePath = ".dbconfig";
        Calendar calendar = new Calendar();
        TransactionRepository transactionRepository = new DatabaseTransactionRepository(dbConfigFilePath, calendar);
        Console console = new Console();
        StatementPrinter statementPrinter = new ConsoleStatementPrinter(console);
        Account account = new Account(transactionRepository, statementPrinter);

        account.deposit(new TransactionAmount(1000));
        account.withdraw(new TransactionAmount(123.45));
        account.deposit(new TransactionAmount(500.01));
        account.print();
    }
}
