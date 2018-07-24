package com.iainhemstock;

import java.sql.SQLException;
import java.util.List;

public interface TransactionRepository {

    void addDeposit(TransactionAmount amount);
    void addWithdrawal(TransactionAmount amount);
    List<Transaction> toList();
    int transactionCount();
}
