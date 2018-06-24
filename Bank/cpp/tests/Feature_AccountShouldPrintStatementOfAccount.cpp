#include <gmock/gmock.h>
using namespace ::testing;
#include "Account.h"
#include "TransactionRepository.h"
#include "StatementPrinter.h"
#include "MockConsole.h"
#include "MockDate.h"
#include <memory>

class FeatureAccountShould : public Test
{
private:
        using MockConsole = NiceMock<MockConsole>;
        using MockDate = NiceMock<MockDate>;
protected:
        std::shared_ptr<MockDate> date{new MockDate};
        std::shared_ptr<TransactionRepository> transactionRepository{new TransactionRepository(date)};
        std::shared_ptr<MockConsole> console{new MockConsole};
        std::shared_ptr<StatementPrinter> statementPrinter{new StatementPrinter(console)};
        Account account{transactionRepository, statementPrinter};
};

TEST_F(FeatureAccountShould, PrintStatementOfAccount)
{
        InSequence seq1;
        EXPECT_CALL(*date, todayAsString()).WillOnce(Return("01/04/2014"));
        EXPECT_CALL(*date, todayAsString()).WillOnce(Return("02/04/2014"));
        EXPECT_CALL(*date, todayAsString()).WillOnce(Return("10/04/2014"));

        InSequence seq2;
        EXPECT_CALL(*console, printLine("DATE | AMOUNT | BALANCE")).Times(1);
        EXPECT_CALL(*console, printLine("10/04/2014 | 500.00 | 1400.00")).Times(1);
        EXPECT_CALL(*console, printLine("02/04/2014 | -100.00 | 900.00")).Times(1);
        EXPECT_CALL(*console, printLine("01/04/2014 | 1000.00 | 1000.00")).Times(1);

        account.deposit(1000);
        account.withdraw(100);
        account.deposit(500);
        account.printStatement();
}
