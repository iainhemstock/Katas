package com.iainhemstock;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConsoleStatementPrinter implements StatementPrinter {

    public static final String STATEMENT_LINE_FORMAT = " %-9s | %-24s | %-10s | %-10s | %10s ";
    public static final String SEPARATOR_CONTAINING_75_HYPHENS = "+ " + new String(new char[75]).replace("\0", "-") + " +";
    private Console console;

    public ConsoleStatementPrinter(Console console) {
        this.console = console;
    }

    @Override
    public void print(List<Transaction> allTransactions) {
        List<String> statementLines = buildStatementLinesFromTransactions(allTransactions);
        Collections.reverse(statementLines);
        printStatement(statementLines);
    }

    private List<String> buildStatementLinesFromTransactions(List<Transaction> allTransactions) {
        double runningBalance = 0.0;
        List<String> statementLines = new ArrayList<>();

        for (Transaction transaction : allTransactions) {
            runningBalance += transaction.amount().toDouble();
            statementLines.add(createStatementLine(runningBalance, transaction));
        }
        return statementLines;
    }

    private String createStatementLine(double runningBalance, Transaction transaction) {
        String statementLine = "";

        if (transactionTypeIsDeposit(transaction.amount())) {
            statementLine = String.format(
                    "|" + STATEMENT_LINE_FORMAT + "|",
                    transaction.date().toString(),
                    "Deposit",
                    "",
                    String.format("%.2f", transaction.amount().toDouble()),
                    String.format("%.2f", runningBalance)
            );
        }
        else {
            statementLine = String.format(
                    "|" + STATEMENT_LINE_FORMAT + "|",
                    transaction.date().toString(),
                    "Withdrawal",
                    String.format("%.2f", transaction.amount().toDouble() * -1),
                    "",
                    String.format("%.2f", runningBalance)
            );
        }
        return statementLine;
    }

    private void printStatement(List<String> statementLines) {
        printHeader();
        statementLines.forEach(statementLine -> printStatementLine(statementLine));
        if (statementLines.size() > 0) printSeparator();

    }

    private void printStatementLine(String statementLine) {
        console.printLine(statementLine);
    }

    private void printHeader() {
        printSeparator();
        printStatementLine(
                String.format("|" + STATEMENT_LINE_FORMAT + "|",
                        "Date", "Payment type and details", "Paid out", "Paid in", "Balance"
                )
        );
        printSeparator();
    }

    private void printSeparator() {
        console.printLine(SEPARATOR_CONTAINING_75_HYPHENS);
    }

    private boolean transactionTypeIsDeposit(TransactionAmount transactionAmount) {
        return transactionAmount.toDouble() >= 0;
    }
}
