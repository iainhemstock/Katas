#include "Date.h"

const std::string
Date::todayAsString() const
{
        struct tm * timeInfo = today();
        char buffer[80];

        strftime(buffer, 80, "%d/%m/%Y", timeInfo);

        return std::string(buffer);
}

tm*
Date::today() const
{
        time_t rawTime;
        struct tm * timeInfo;

        time(&rawTime);
        timeInfo = localtime(&rawTime);

        return timeInfo;
}
