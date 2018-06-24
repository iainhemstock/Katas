#ifndef DATE_H_
#define DATE_H_

#include "IDate.h"
#include <ctime>

class Date : public IDate
{
public:
        const std::string todayAsString();
protected:
        virtual std::tm today();
protected:
        std::tm timeInfo;
};

#endif
