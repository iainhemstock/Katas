package com.iainhemstock;

public class TransactionAmount {

    private final double amount;

    public TransactionAmount(final double amount) {
        this.amount = amount;
    }

    public double toDouble() {
        return this.amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionAmount that = (TransactionAmount) o;
        return amount == that.amount;
    }

    public TransactionAmount negated() {
        return new TransactionAmount(-this.amount);
    }

    @Override
    public String toString() {
        return "TransactionAmount{" +
                "amount=" + amount +
                '}';
    }
}
