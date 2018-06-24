#include "TransactionRepository.h"
#include "Transaction.h"
#include "IDate.h"

TransactionRepository::TransactionRepository(std::shared_ptr<IDate> date)
: date{date}
{}

void
TransactionRepository::addDeposit(const int amount)
{
        const std::string today = this->date->todayAsString();
        transactions.push_back(Transaction(today, amount));
}

void
TransactionRepository::addWithdrawal(const int amount)
{
        const std::string today = this->date->todayAsString();
        transactions.push_back(Transaction(today, -amount));
}

std::list<Transaction>
TransactionRepository::allTransactions() const
{
        return transactions;
}
