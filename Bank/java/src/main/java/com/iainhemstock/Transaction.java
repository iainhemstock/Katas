package com.iainhemstock;

import java.util.Objects;

public class Transaction {
    private final TransactionAmount transactionAmount;
    private final TransactionDate date;


    public Transaction(TransactionAmount transactionAmount, TransactionDate date) {
        this.transactionAmount = transactionAmount;
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(transactionAmount, that.transactionAmount);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionAmount=" + transactionAmount +
                '}';
    }

    public TransactionAmount amount() {
        return this.transactionAmount;
    }

    public TransactionDate date() {
        return this.date;
    }
}
