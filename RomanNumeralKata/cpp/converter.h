const std::string converter(int arabic)
{
        std::string roman{};

        std::pair<int, std::string> table[] = {
                std::make_pair(10, "X"),
                std::make_pair(5, "V"),
                std::make_pair(4, "IV"),
                std::make_pair(1, "I")
        };

        for (auto pair : table)
        {
                while (arabic >= pair.first)
                {
                        roman += pair.second;
                        arabic -= pair.first;
                }
        }

        return roman;
}
