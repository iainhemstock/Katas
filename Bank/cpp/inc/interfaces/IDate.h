#ifndef IDATE_H_
#define IDATE_H_

#include <string>

class IDate
{
public:
        virtual const std::string todayAsString() const = 0;
};

#endif
