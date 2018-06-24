#ifndef MOCK_DATE_H_
#define MOCK_DATE_H_

#include "IDate.h"

class MockDate : public IDate
{
public:
        MOCK_CONST_METHOD0(todayAsString, const std::string());
};

#endif
