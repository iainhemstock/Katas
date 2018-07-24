package com.iainhemstock.unit;

import com.iainhemstock.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AccountShould {

    private TransactionRepository transactionRepository = mock(TransactionRepository.class);
    private StatementPrinter statementPrinter = mock(StatementPrinter.class);
    private Account account = new Account(transactionRepository, statementPrinter);

    @Test
    public void store_a_deposit_transaction() {
        TransactionAmount amount = new TransactionAmount(123.45);
        account.deposit(amount);
        verify(transactionRepository).addDeposit(amount);
    }

    @Test
    public void store_a_withdrawal_transaction() {
        TransactionAmount amount = new TransactionAmount(234.56);
        account.withdraw(amount);
        verify(transactionRepository).addWithdrawal(amount);
    }

    @Test
    public void print_statement_of_transactions() {
        given(transactionRepository.toList()).willReturn(emptyTransactionCollection());
        account.print();
        verify(statementPrinter).print(emptyTransactionCollection());
    }

    private List<Transaction> emptyTransactionCollection() {
        return Collections.emptyList();
    }

}
