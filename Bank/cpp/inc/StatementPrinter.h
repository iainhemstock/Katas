#ifndef STATEMENT_PRINTER_H_
#define STATEMENT_PRINTER_H_

#include "IStatementPrinter.h"
#include <list>
#include <memory>

class Transaction;
class IConsole;

class StatementPrinter : public IStatementPrinter
{
public:
        StatementPrinter(std::shared_ptr<IConsole> console);
        void print(std::list<Transaction> transactions) override;
private:
        const std::string generateStatementLine(const Transaction& transaction);
        std::list<std::string> generateStatementLines(const std::list<Transaction>& transactions);
        void printStatementHeader() const;
        void printStatementLines(const std::list<std::string>& statementLines) const;
private:
        std::shared_ptr<IConsole> console;
        int runningBalance{0};
        const std::string STATEMENT_HEADER{"DATE | AMOUNT | BALANCE"};
};

#endif
