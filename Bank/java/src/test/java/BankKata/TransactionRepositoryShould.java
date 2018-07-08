package BankKata;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class TransactionRepositoryShould {

    @Mock private Calendar calendar;
    @Mock private TransactionDate today;
    private Money amount = new Money(100);
    private TransactionRepository transactionRepository;

    @Before
    public void setUp() {
        this.transactionRepository = new InMemoryTransactionRepository(calendar);
        given(calendar.today()).willReturn(today);
    }

    @Test
    public void create_and_store_a_deposit_transaction() {
        this.transactionRepository.addDeposit(amount);
        assertThat(transactionCount(), is(1));
        assertThat(firstTransaction(), is(new Transaction(today, amount)));
    }

    @Test
    public void create_and_store_a_withdrawal_transaction() {
        this.transactionRepository.addWithdrawal(amount);
        assertThat(transactionCount(), is(1));
        assertThat(firstTransaction(), is(new Transaction(today, amount.negated())));
    }

    private final int transactionCount() {
        return transactionRepository.allTransactions().size();
    }

    private final Transaction firstTransaction() {
        return transactionRepository.allTransactions().get(0);
    }

}
