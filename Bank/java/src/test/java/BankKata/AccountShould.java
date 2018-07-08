package BankKata;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AccountShould {

    @Mock private TransactionRepository transactionRepository;
    @Mock private StatementPrinter statementPrinter;
    private Account account;

    @Before
    public void setUp() {
        this.account = new Account(transactionRepository, statementPrinter);
    }

    @Test
    public void store_a_deposit_transaction() {
        TransactionAmount amount = new TransactionAmount(100);
        this.account.deposit(amount);
        verify(transactionRepository).addDeposit(amount);
    }

    @Test
    public void store_a_withdrawal_transaction() {
        TransactionAmount amount = new TransactionAmount(100);
        this.account.withdraw(amount);
        verify(transactionRepository).addWithdrawal(amount);
    }

    @Test
    public void print_statement_of_transactions() {
        List<Transaction> transactions = Collections.emptyList();
        given(transactionRepository.allTransactions()).willReturn(transactions);
        this.account.printStatement();
        verify(statementPrinter).print(transactions);
    }
}