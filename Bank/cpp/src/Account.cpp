#include "Account.h"
#include "ITransactionRepository.h"
#include "IStatementPrinter.h"

Account::Account(std::shared_ptr<ITransactionRepository> transactionRepository, std::shared_ptr<IStatementPrinter> statementPrinter)
: transactionRepository{transactionRepository}, statementPrinter{statementPrinter}
{}

void
Account::deposit(const int amount)
{
        this->transactionRepository->addDeposit(amount);
}

void
Account::withdraw(const int amount)
{
        this->transactionRepository->addWithdrawal(amount);
}

void
Account::printStatement()
{
        std::list<Transaction> transactions = this->transactionRepository->allTransactions();
        this->statementPrinter->print(transactions);
}
