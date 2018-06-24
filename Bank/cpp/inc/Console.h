#ifndef CONSOLE_H_
#define CONSOLE_H_

#include "IConsole.h"

class Console : public IConsole
{
public:
        void printLine(const std::string& line) override;
};

#endif
