package com.iainhemstock;

import java.util.List;

public interface StatementPrinter {
    void print(List<Transaction> allTransactions);
}
