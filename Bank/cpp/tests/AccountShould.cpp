#include <gmock/gmock.h>
using namespace ::testing;
#include "Account.h"
#include "MockTransactionRepository.h"
#include "Transaction.h"
#include "MockStatementPrinter.h"
#include <memory>
#include <list>

class AccountShould : public Test
{
private:
        using MockTransactionRepository = NiceMock<MockTransactionRepository>;
        using MockStatementPrinter = NiceMock<MockStatementPrinter>;
protected:
        std::shared_ptr<MockTransactionRepository> transactionRepository{new MockTransactionRepository};
        std::shared_ptr<MockStatementPrinter> statementPrinter{new MockStatementPrinter};
        Account account{transactionRepository, statementPrinter};
};

TEST_F(AccountShould, StoreDepositTransaction)
{
        EXPECT_CALL(*transactionRepository, addDeposit(100)).Times(1);
        account.deposit(100);
}

TEST_F(AccountShould, StoreWithdrawalTransaction)
{
        EXPECT_CALL(*transactionRepository, addWithdrawal(100)).Times(1);
        account.withdraw(100);
}

TEST_F(AccountShould, PrintStatementOfAccount)
{
        std::list<Transaction> transactions;
        EXPECT_CALL(*transactionRepository, allTransactions()).WillOnce(Return(transactions));
        EXPECT_CALL(*statementPrinter, print(transactions)).Times(1);
        account.printStatement();
}
