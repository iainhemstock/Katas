package BankKata;

import java.util.List;

class Account {
    private TransactionRepository transactionRepository;
    private StatementPrinter statementPrinter;

    Account(TransactionRepository transactionRepository, StatementPrinter statementPrinter) {
        this.transactionRepository = transactionRepository;
        this.statementPrinter = statementPrinter;
    }

    void deposit(TransactionAmount transactionAmount) {
        this.transactionRepository.addDeposit(transactionAmount);
    }

    void withdraw(TransactionAmount transactionAmount) {
        this.transactionRepository.addWithdrawal(transactionAmount);
    }

    void printStatement() {
        List<Transaction> transactions = this.transactionRepository.allTransactions();
        this.statementPrinter.print(transactions);
    }
}
