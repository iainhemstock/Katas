#ifndef MOCK_CONSOLE_H_
#define MOCK_CONSOLE_H_

#include "IConsole.h"
#include <string>

class MockConsole : public IConsole
{
public:
        MOCK_METHOD1(printLine, void (const std::string&));
};

#endif
