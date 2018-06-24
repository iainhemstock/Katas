#include <gmock/gmock.h>
using namespace ::testing;
#include "StatementPrinter.h"
#include "MockConsole.h"
#include "Transaction.h"
#include <memory>

class StatementPrinterShould : public Test
{
private:
        using MockConsole = NiceMock<MockConsole>;
protected:
        std::shared_ptr<MockConsole> console{new MockConsole};
        StatementPrinter statementPrinter{console};
};

TEST_F(StatementPrinterShould, AlwaysPrintTheHeader)
{
        EXPECT_CALL(*console, printLine("DATE | AMOUNT | BALANCE"));
        std::list<Transaction> noTransactions;
        statementPrinter.print(noTransactions);
}

TEST_F(StatementPrinterShould, PrintAllTransactionsInReverseOrder)
{
        InSequence sequence;
        EXPECT_CALL(*console, printLine("DATE | AMOUNT | BALANCE"));
        EXPECT_CALL(*console, printLine("10/04/2014 | 500.00 | 1400.00"));
        EXPECT_CALL(*console, printLine("02/04/2014 | -100.00 | 900.00"));
        EXPECT_CALL(*console, printLine("01/04/2014 | 1000.00 | 1000.00"));

        std::list<Transaction> transactions;
        transactions.push_back(Transaction("01/04/2014", 1000));
        transactions.push_back(Transaction("02/04/2014", -100));
        transactions.push_back(Transaction("10/04/2014", 500));

        statementPrinter.print(transactions);
}
