package BankKata;

import java.util.List;

public interface TransactionRepository {
    void addDeposit(TransactionAmount amount);
    void addWithdrawal(TransactionAmount amount);
    List<Transaction> allTransactions();
}
