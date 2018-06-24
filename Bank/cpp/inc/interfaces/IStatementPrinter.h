#ifndef ISTATEMENT_PRINTER_H_
#define ISTATEMENT_PRINTER_H_

#include <list>

class Transaction;

class IStatementPrinter
{
public:
        virtual ~IStatementPrinter() {}
        virtual void print(std::list<Transaction> transactions) = 0;
};

#endif
