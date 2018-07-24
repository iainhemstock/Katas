package com.iainhemstock.unit;

import com.iainhemstock.*;
import org.junit.Test;
import org.mockito.InOrder;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;

public class ConsoleStatementPrinterShould {

    private Console console = mock(Console.class);
    private StatementPrinter consoleStatementPrinter = new ConsoleStatementPrinter(console);

    @Test
    public void print_statement_header() {
        List<Transaction> transactions = Collections.emptyList();
        consoleStatementPrinter.print(transactions);
        InOrder order = inOrder(console);
        order.verify(console).printLine("+ ------------------------------------------------------------------------- +");
        order.verify(console).printLine("| Date      | Payment type and details | Paid out   | Paid in   |   Balance |");
        order.verify(console).printLine("+ ------------------------------------------------------------------------- +");
    }

    @Test
    public void print_single_deposit_transaction() {
        TransactionAmount amount = new TransactionAmount(123.45);
        TransactionDate date = new TransactionDate("21 Jan 71");
        Transaction transaction = new Transaction(amount, date);
        List<Transaction> transactions = Arrays.asList(transaction);
        consoleStatementPrinter.print(transactions);

        InOrder order = inOrder(console);
        order.verify(console).printLine("+ ------------------------------------------------------------------------- +");
        order.verify(console).printLine("| Date      | Payment type and details | Paid out   | Paid in   |   Balance |");
        order.verify(console).printLine("+ ------------------------------------------------------------------------- +");
        order.verify(console).printLine("+ 21 Jan 71 |                          |            |    123.45 |    123.45 +");
        order.verify(console).printLine("+ ------------------------------------------------------------------------- +");
    }

    @Test
    public void print_single_Withdrawal_transaction() {
        TransactionAmount amount = new TransactionAmount(123.45);
        TransactionDate date = new TransactionDate("21 Jan 71");
        Transaction transaction = new Transaction(amount.negated(), date);
        List<Transaction> transactions = Arrays.asList(transaction);
        consoleStatementPrinter.print(transactions);

        InOrder order = inOrder(console);
        order.verify(console).printLine("+ ------------------------------------------------------------------------- +");
        order.verify(console).printLine("| Date      | Payment type and details | Paid out   | Paid in   |   Balance |");
        order.verify(console).printLine("+ ------------------------------------------------------------------------- +");
        order.verify(console).printLine("+ 21 Jan 71 |                          |     123.45 |           |   -123.45 +");
        order.verify(console).printLine("+ ------------------------------------------------------------------------- +");
    }

}
