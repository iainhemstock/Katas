#ifndef ICONSOLE_H_
#define ICONSOLE_H_

#include <string>

class IConsole
{
public:
        virtual void printLine(const std::string& line) = 0;
};

#endif
