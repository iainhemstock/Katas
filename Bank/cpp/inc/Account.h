#ifndef ACCOUNT_H_
#define ACCOUNT_H_

#include <memory>

class ITransactionRepository;
class IStatementPrinter;

class Account
{
public:
        Account(std::shared_ptr<ITransactionRepository> transactionRepository, std::shared_ptr<IStatementPrinter> statementPrinter);

        void deposit(const int amount);
        void withdraw(const int amount);
        void printStatement();
private:
        std::shared_ptr<ITransactionRepository> transactionRepository;
        std::shared_ptr<IStatementPrinter> statementPrinter;
};

#endif
