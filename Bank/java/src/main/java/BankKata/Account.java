package BankKata;

import java.util.List;

class Account {
    private TransactionRepository transactionRepository;
    private StatementPrinter statementPrinter;

    Account(TransactionRepository transactionRepository, StatementPrinter statementPrinter) {
        this.transactionRepository = transactionRepository;
        this.statementPrinter = statementPrinter;
    }

    void deposit(Money money) {
        this.transactionRepository.addDeposit(money);
    }

    void withdraw(Money money) {
        this.transactionRepository.addWithdrawal(money);
    }

    void printStatement() {
        List<Transaction> transactions = this.transactionRepository.allTransactions();
        this.statementPrinter.print(transactions);
    }
}
