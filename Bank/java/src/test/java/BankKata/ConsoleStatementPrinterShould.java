package BankKata;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ConsoleStatementPrinterShould {

    private static final String STATEMENT_HEADER = "DATE | AMOUNT | BALANCE";
    @Mock private Console console;
    private StatementPrinter statementPrinter;

    @Before
    public void setUp() {
        this.statementPrinter = new ConsoleStatementPrinter(console);
    }

    @Test
    public void print_header_of_statement() {
        List<Transaction> transactions = Collections.emptyList();
        this.statementPrinter.print(transactions);
        verify(console).printLine(STATEMENT_HEADER);
    }

    @Test
    public void print_single_transaction() {
        List<Transaction> singleTransactionList = Arrays.asList(
                new Transaction(
                        new TransactionDate("21/01/1971"),
                        new TransactionAmount(500))
        );
        this.statementPrinter.print(singleTransactionList);

        InOrder order = inOrder(console);
        order.verify(console).printLine(STATEMENT_HEADER);
        order.verify(console).printLine("21/01/1971 | 500.00 | 500.00");
    }

    @Test
    public void print_multiple_transactions_in_reverse_chronological_order() {
        List<Transaction> threeTransactionsList = Arrays.asList(
                new Transaction(new TransactionDate("01/01/2000"), new TransactionAmount(50)),
                new Transaction(new TransactionDate("02/01/2000"), new TransactionAmount(100)),
                new Transaction(new TransactionDate("03/01/2000"), new TransactionAmount(150))
        );
        this.statementPrinter.print(threeTransactionsList);

        InOrder order = inOrder(console);
        order.verify(console).printLine(STATEMENT_HEADER);
        order.verify(console).printLine("03/01/2000 | 150.00 | 300.00");
        order.verify(console).printLine("02/01/2000 | 100.00 | 150.00");
        order.verify(console).printLine("01/01/2000 | 50.00 | 50.00");
    }

}
