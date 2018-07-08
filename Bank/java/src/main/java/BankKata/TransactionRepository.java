package BankKata;

import java.util.List;

public interface TransactionRepository {
    void addDeposit(Money amount);
    void addWithdrawal(Money amount);
    List<Transaction> allTransactions();
}
