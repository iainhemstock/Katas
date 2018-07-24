package com.iainhemstock;

import java.util.List;

public class ConsoleStatementPrinter implements StatementPrinter {

    private Console console;

    public ConsoleStatementPrinter(Console console) {
        this.console = console;
    }

    @Override
    public void print(List<Transaction> allTransactions) {
        printHeader();

        if (!allTransactions.isEmpty()) {
            Transaction transaction = allTransactions.get(0);
            TransactionAmount amount = transaction.amount();
            TransactionDate date = transaction.date();
            if (amount.toDouble() >= 0) {
                console.printLine(String.format(
                        "+ %s |                          |            |    %.2f |    %.2f +",
                        date.toString(), amount.toDouble(), amount.toDouble()
                ));
            }
            else {
                console.printLine(String.format(
                        "+ %s |                          |     %.2f |           |   %.2f +",
                        date.toString(), amount.toDouble() * -1, amount.toDouble()
                ));
            };
            printSeparator();
        }
    }

    private void printHeader() {
        printSeparator();
        console.printLine("| Date      | Payment type and details | Paid out   | Paid in   |   Balance |");
        printSeparator();
    }

    private void printSeparator() {
        console.printLine("+ ------------------------------------------------------------------------- +");
    }
}
