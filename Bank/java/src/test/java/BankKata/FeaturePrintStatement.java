package BankKata;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.inOrder;

@RunWith(MockitoJUnitRunner.class)
public class FeaturePrintStatement {

    @Mock private Console console;
    @Mock private Calendar calendar;
    private Account account;

    @Before
    public void setUp() {
        TransactionRepository transactionRepository = new InMemoryTransactionRepository(calendar);
        StatementPrinter statementPrinter = new ConsoleStatementPrinter(console);
        this.account = new Account(transactionRepository, statementPrinter);
    }

    @Test
    public void print_statement_containing_all_transactions()
    {
        given(calendar.today()).willReturn(
                new TransactionDate("01/04/2014"),
                new TransactionDate("02/04/2014"),
                new TransactionDate("10/04/2014")
        );

        account.deposit(new TransactionAmount(1000));
        account.withdraw(new TransactionAmount(100));
        account.deposit(new TransactionAmount(500));

        account.printStatement();

        InOrder order = inOrder(console);
        order.verify(console).printLine("DATE | AMOUNT | BALANCE");
        order.verify(console).printLine("10/04/2014 | 500.00 | 1400.00");
        order.verify(console).printLine("02/04/2014 | -100.00 | 900.00");
        order.verify(console).printLine("01/04/2014 | 1000.00 | 1000.00");
    }
}
