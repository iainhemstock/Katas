#include "StatementPrinter.h"
#include "IConsole.h"
#include "Transaction.h"
#include <sstream>

StatementPrinter::StatementPrinter(std::shared_ptr<IConsole> console)
: console{console}
{}

void
StatementPrinter::print(std::list<Transaction> transactions)
{
        std::list<std::string> statementLines = this->generateStatementLines(transactions);
        statementLines.reverse();

        printStatementHeader();
        printStatementLines(statementLines);
}

std::list<std::string>
StatementPrinter::generateStatementLines(const std::list<Transaction>& transactions)
{
        std::list<std::string> statementLines;
        for (auto it = transactions.cbegin(); it != transactions.cend(); ++it) {
                this->runningBalance += it->amount();
                statementLines.push_back(generateStatementLine(*it));
        }
        return statementLines;
}

void
StatementPrinter::printStatementHeader() const
{
        this->console->printLine(STATEMENT_HEADER);
}

void
StatementPrinter::printStatementLines(const std::list<std::string>& statementLines) const
{
        for (auto line : statementLines)
                this->console->printLine(line);
}

const std::string
StatementPrinter::generateStatementLine(const Transaction& transaction)
{
        std::stringstream ss;
        ss << transaction.date()
           << " | "
           << transaction.amount() << ".00"
           << " | "
           << this->runningBalance << ".00";

          return ss.str();
}
