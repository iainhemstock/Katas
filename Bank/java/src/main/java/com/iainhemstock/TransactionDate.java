package com.iainhemstock;

public class TransactionDate {

    private final String date;

    public TransactionDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return this.date;
    }
}
