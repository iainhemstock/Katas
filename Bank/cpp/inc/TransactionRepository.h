#ifndef TRANSACTION_REPOSITORY_H_
#define TRANSACTION_REPOSITORY_H_

#include "ITransactionRepository.h"
#include <list>
#include <memory>

class Transaction;
class IDate;

class TransactionRepository : public ITransactionRepository
{
public:
        TransactionRepository(std::shared_ptr<IDate> date);

        void addDeposit(const int amount) override;
        void addWithdrawal(const int amount) override;
        std::list<Transaction> allTransactions() const override;
private:
        std::list<Transaction> transactions;
        std::shared_ptr<IDate> date;
};

#endif
