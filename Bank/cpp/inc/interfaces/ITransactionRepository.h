#ifndef ITRANSACTION_REPOSITORY_H_
#define ITRANSACTION_REPOSITORY_H_

#include "Transaction.h"
#include <list>

class ITransactionRepository
{
public:
        virtual ~ITransactionRepository() {}
        virtual void addDeposit(const int amount) = 0;
        virtual void addWithdrawal(const int amount) = 0;
        virtual std::list<Transaction> allTransactions() const = 0;
};

#endif
