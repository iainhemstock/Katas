#ifndef MOCK_STATEMENT_PRINTER_H_
#define MOCK_STATEMENT_PRINTER_H_

#include "IStatementPrinter.h"
#include <list>

class MockStatementPrinter : public IStatementPrinter
{
public:
        MOCK_METHOD1(print, void(std::list<Transaction>));
};

#endif
