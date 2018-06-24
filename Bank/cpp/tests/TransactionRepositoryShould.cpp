#include <gmock/gmock.h>
using namespace ::testing;
#include "TransactionRepository.h"
#include "MockDate.h"
#include <memory>

class TransactionRepositoryShould : public Test
{
private:
        using MockDate = NiceMock<MockDate>;
protected:
        std::shared_ptr<MockDate> date{new MockDate};
        TransactionRepository transactionRepository{date};
};

TEST_F(TransactionRepositoryShould, CreateAndStoreDepositTransaction)
{
        const std::string TODAY = "22/06/2018";
        EXPECT_CALL(*date, todayAsString()).WillOnce(Return(TODAY));

        const int amount = 100;
        transactionRepository.addDeposit(amount);

        auto transactions = transactionRepository.allTransactions();
        EXPECT_THAT(transactions.size(), Eq(1));
        EXPECT_THAT(transactions.front(), Eq(Transaction(TODAY, amount)));
}

TEST_F(TransactionRepositoryShould, CreateAndStoreWithdrawalTransaction)
{
        const std::string TODAY = "22/06/2018";
        EXPECT_CALL(*date, todayAsString()).WillOnce(Return(TODAY));

        const int amount = 100;
        transactionRepository.addWithdrawal(amount);

        auto transactions = transactionRepository.allTransactions();
        EXPECT_THAT(transactions.size(), Eq(1));
        EXPECT_THAT(transactions.front(), Eq(Transaction(TODAY, -amount)));
}
