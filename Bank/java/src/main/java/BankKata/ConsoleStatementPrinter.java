package BankKata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class ConsoleStatementPrinter implements StatementPrinter {

    private static final String STATEMENT_HEADER = "DATE | AMOUNT | BALANCE";
    private Console console;
    private int runningBalance;

    public ConsoleStatementPrinter(Console console) {
        this.console = console;
    }

    @Override
    public void print(List<Transaction> transactions) {
        List<String> statementLines = generateStatementLines(transactions);
        Collections.reverse(statementLines);

        printStatementHeader();
        printStatementLines(statementLines);
    }

    private void printStatementLines(List<String> statementLines) {
        ListIterator<String> iter = statementLines.listIterator();
        while (iter.hasNext()) {
            this.console.printLine(iter.next());
        }
    }

    private List<String> generateStatementLines(List<Transaction> transactions) {
        List<String> statementLines = new ArrayList<>();

        ListIterator<Transaction> iter = transactions.listIterator();
        while (iter.hasNext()) {
            Transaction transaction = iter.next();
            statementLines.add(this.generateStatementLineFromTransaction(transaction));
        }
        return statementLines;
    }

    private void printStatementHeader() {
        this.console.printLine(STATEMENT_HEADER);
    }

    private String generateStatementLineFromTransaction(Transaction transaction) {
        return this.getTransactionDate(transaction) +
                " | " +
                this.getTransactionAmount(transaction) + ".00" +
                " | " +
                this.getAccountRunningBalance(transaction) + ".00";
    }

    private String getAccountRunningBalance(Transaction transaction) {
        this.runningBalance += transaction.amountAsInt();
        return String.valueOf(this.runningBalance);
    }

    private String getTransactionAmount(Transaction transaction) {
        StringBuilder sb = new StringBuilder();
        transaction.addAmountToStringBuilder(sb);
        return sb.toString();
    }

    private String getTransactionDate(Transaction transaction) {
        StringBuilder sb = new StringBuilder();
        transaction.addDateToStringBuilder(sb);
        return sb.toString();
    }
}
