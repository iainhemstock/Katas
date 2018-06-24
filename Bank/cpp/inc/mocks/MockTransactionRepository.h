#ifndef MOCK_TRANSACTION_REPOSITORY_H_
#define MOCK_TRANSACTION_REPOSITORY_H_

#include "ITransactionRepository.h"
#include "Transaction.h"
#include <list>

class MockTransactionRepository : public ITransactionRepository
{
public:
        MOCK_METHOD1(addDeposit, void(const int));
        MOCK_METHOD1(addWithdrawal, void(const int));
        MOCK_CONST_METHOD0(allTransactions, std::list<Transaction>(void));
};

#endif
