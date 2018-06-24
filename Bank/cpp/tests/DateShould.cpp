#include <gmock/gmock.h>
using namespace ::testing;
#include "Date.h"

class TestableDate : public Date
{
public:
        tm* today() const
        {
                time_t rawTime;
                struct tm * timeInfo = localtime(&rawTime);
                timeInfo->tm_mday = 12;
                timeInfo->tm_mon = 2;
                timeInfo->tm_year = 113;

                return timeInfo;
        }
};

class DateShould : public Test
{
protected:
        TestableDate date;
};

TEST_F(DateShould, ReturnTodaysDateFormattedAsDDMMYYYY)
{
        std::string today = date.todayAsString();
        EXPECT_THAT(today, Eq("12/03/2013"));
}
