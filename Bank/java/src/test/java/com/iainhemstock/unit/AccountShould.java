package com.iainhemstock.unit;

import com.iainhemstock.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class AccountShould {

    @Mock private TransactionRepository transactionRepository;
    @Mock private StatementPrinter statementPrinter;
    private Account account;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        account = new Account(transactionRepository, statementPrinter);
    }

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
