#include "Date.h"

const std::string
Date::todayAsString()
{
        std::tm timeInfo = today();
        char buffer[80];

        strftime(buffer, 80, "%d/%m/%Y", &timeInfo);

        return std::string(buffer);
}

std::tm
Date::today()
{
        time_t rawTime;
        time(&rawTime);
        this->timeInfo = *localtime(&rawTime);

        return this->timeInfo;
}
