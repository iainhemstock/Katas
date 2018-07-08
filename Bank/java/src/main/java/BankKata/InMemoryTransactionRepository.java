package BankKata;

import java.util.ArrayList;
import java.util.List;

public class InMemoryTransactionRepository implements TransactionRepository {

    private Calendar calendar;
    private List<Transaction> transactions = new ArrayList<>();

    public InMemoryTransactionRepository(Calendar calendar) {
        this.calendar = calendar;
    }

    @Override
    public void addDeposit(TransactionAmount transactionAmount) {
        addTransaction(transactionAmount);
    }

    @Override
    public void addWithdrawal(TransactionAmount transactionAmount) {
        addTransaction(transactionAmount.negated());
    }

    private void addTransaction(TransactionAmount transactionAmount) {
        TransactionDate today = this.calendar.today();
        Transaction transaction = new Transaction(today, transactionAmount);
        transactions.add(transaction);
    }

    @Override
    public final List<Transaction> allTransactions() {
        return transactions;
    }
}
