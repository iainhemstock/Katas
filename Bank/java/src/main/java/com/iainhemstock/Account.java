package com.iainhemstock;

import java.util.List;

public class Account {

    private TransactionRepository transactionRepository;
    private StatementPrinter statementPrinter;

    public Account(TransactionRepository transactionRepository, StatementPrinter statementPrinter) {
        this.transactionRepository = transactionRepository;
        this.statementPrinter = statementPrinter;
    }

    public void deposit(TransactionAmount amount) {
        this.transactionRepository.addDeposit(amount);
    }

    public void withdraw(TransactionAmount amount) {
        this.transactionRepository.addWithdrawal(amount);
    }

    public void print() {
        List<Transaction> allTransactions = this.transactionRepository.toList();
        this.statementPrinter.print(allTransactions);
    }
}
