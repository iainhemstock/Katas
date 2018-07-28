package com.iainhemstock.unit;

import com.iainhemstock.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.inOrder;

public class ConsoleStatementPrinterShould {

    private static final Transaction DEPOSIT_TRANSACTION = new Transaction(
            new TransactionAmount(234.56), new TransactionDate("21 Jan 71"));
    private static final Transaction WITHDRAWAL_TRANSACTION = new Transaction(
            new TransactionAmount(123.45).negated(), new TransactionDate("22 Jan 71"));

    @Mock private Console console;

    private StatementPrinter consoleStatementPrinter;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        consoleStatementPrinter = new ConsoleStatementPrinter(console);
    }

    @Test
    public void print_statement_header() {
        List<Transaction> transactions = Collections.emptyList();
        consoleStatementPrinter.print(transactions);

        InOrder order = inOrder(console);
        order.verify(console).printLine("+ --------------------------------------------------------------------------- +");
        order.verify(console).printLine("| Date      | Payment type and details | Paid out   | Paid in    |    Balance |");
        order.verify(console).printLine("+ --------------------------------------------------------------------------- +");
    }

    @Test
    public void print_single_deposit_transaction() {
        List<Transaction> transactions = Arrays.asList(DEPOSIT_TRANSACTION);
        consoleStatementPrinter.print(transactions);

        InOrder order = inOrder(console);
        order.verify(console).printLine("+ --------------------------------------------------------------------------- +");
        order.verify(console).printLine("| Date      | Payment type and details | Paid out   | Paid in    |    Balance |");
        order.verify(console).printLine("+ --------------------------------------------------------------------------- +");
        order.verify(console).printLine("| 21 Jan 71 | Deposit                  |            | 234.56     |     234.56 |");
        order.verify(console).printLine("+ --------------------------------------------------------------------------- +");
    }

    @Test
    public void print_single_Withdrawal_transaction() {
        List<Transaction> transactions = Arrays.asList(WITHDRAWAL_TRANSACTION);
        consoleStatementPrinter.print(transactions);

        InOrder order = inOrder(console);
        order.verify(console).printLine("+ --------------------------------------------------------------------------- +");
        order.verify(console).printLine("| Date      | Payment type and details | Paid out   | Paid in    |    Balance |");
        order.verify(console).printLine("+ --------------------------------------------------------------------------- +");
        order.verify(console).printLine("| 22 Jan 71 | Withdrawal               | 123.45     |            |    -123.45 |");
        order.verify(console).printLine("+ --------------------------------------------------------------------------- +");
    }
    
    @Test
    public void print_multiple_transactions_in_reverse_chronological_order() {
        List<Transaction> transactions = Arrays.asList(
                DEPOSIT_TRANSACTION,
                WITHDRAWAL_TRANSACTION
        );
        consoleStatementPrinter.print(transactions);

        InOrder order = inOrder(console);
        order.verify(console).printLine("+ --------------------------------------------------------------------------- +");
        order.verify(console).printLine("| Date      | Payment type and details | Paid out   | Paid in    |    Balance |");
        order.verify(console).printLine("+ --------------------------------------------------------------------------- +");
        order.verify(console).printLine("| 22 Jan 71 | Withdrawal               | 123.45     |            |     111.11 |");
        order.verify(console).printLine("| 21 Jan 71 | Deposit                  |            | 234.56     |     234.56 |");
        order.verify(console).printLine("+ --------------------------------------------------------------------------- +");
    }

}
