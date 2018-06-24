#include <gmock/gmock.h>
using namespace ::testing;
#include "Date.h"

class TestableDate : public Date
{
public:
        std::tm today()
        {
                this->timeInfo.tm_mday = 12;
                this->timeInfo.tm_mon = 2;
                this->timeInfo.tm_year = 113;

                return this->timeInfo;
        }
private:

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
