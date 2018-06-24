#ifndef DATE_H_
#define DATE_H_

#include "IDate.h"
#include <ctime>

class Date : public IDate
{
public:
        const std::string todayAsString() const;
protected:
        virtual tm* today() const;
};

#endif
