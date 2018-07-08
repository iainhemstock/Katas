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
    public void addDeposit(Money money) {
        addTransaction(money);
    }

    @Override
    public void addWithdrawal(Money money) {
        addTransaction(money.negated());
    }

    private void addTransaction(Money money) {
        TransactionDate today = this.calendar.today();
        Transaction transaction = new Transaction(today, money);
        transactions.add(transaction);
    }

    @Override
    public final List<Transaction> allTransactions() {
        return transactions;
    }
}
