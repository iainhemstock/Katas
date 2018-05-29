#include <gmock/gmock.h>
using namespace ::testing;
#include <string>
#include <sstream>
#include <vector>

const std::vector<std::string> split(const std::string& name, const char delim)
{
        std::stringstream ss(name);
        std::string token;
        std::vector<std::string> tokens;
        while (std::getline(ss, token, delim))
                tokens.push_back(token);

        return tokens;
}

const bool isHonorific(const std::string& namePart)
{
        std::vector<std::string> knownHonorifics = { "Mr.", "Mrs." };
        for (auto honorific : knownHonorifics)
                if (namePart == honorific) return true;
        return false;
}

void removeHonorific(std::vector<std::string>& nameParts)
{
        nameParts.erase(nameParts.cbegin());
}

const std::string buildString(const std::string& first, const std::string& last, const std::string& postnominal)
{
        return last + ", " + first + " " + postnominal;
}

const std::string trim(const std::string& str)
{
        std::string trimmed = str;
        const std::string ws = " ";
        std::size_t found = trimmed.find_last_not_of(ws);
        if (found != std::string::npos)
                trimmed.erase(found + 1);
        return trimmed;
}

const std::string findAndMergePostnominals(const std::vector<std::string>& nameParts)
{
        std::string postnominals;
        if (nameParts.size() >=3)
        {
                for (int i = 2; i < nameParts.size(); ++i)
                        postnominals += nameParts[i] + " ";
        }
        return postnominals;
}

const std::string invert(const std::string& name)
{
        std::string ret;
        std::vector<std::string> nameParts = split(name, ' ');

        if (nameParts.size() == 0) ret = "";
        else if (nameParts.size() == 1) ret = nameParts[0];
        else if (nameParts.size() >= 2)
        {
                if (isHonorific(nameParts[0])) removeHonorific(nameParts);
                ret = buildString(nameParts[0], nameParts[1], findAndMergePostnominals(nameParts));
        }

        return trim(ret);
}

TEST(NameInverterShould, ReturnEmptyStringWhenNameIsEmpty)
{
        EXPECT_THAT(invert(""), Eq(""));
}

TEST(NameInverterShould, ReturnSameNameWhenSingleNameIsGiven)
{
        EXPECT_THAT(invert("John"), Eq("John"));
}

TEST(NameInverterShould, ReturnLastNameCommaFirstName)
{
        EXPECT_THAT(invert("John Smith"), Eq("Smith, John"));
}

TEST(NameInverterShould, ReturnLastNameCommaFirstNameWhilstIgnoringHonorific)
{
        EXPECT_THAT(invert("Mr. John Smith"), Eq("Smith, John"));
        EXPECT_THAT(invert("Mrs. Jane Doe"), Eq("Doe, Jane"));
}

TEST(NameInverterShould, ReturnLastNameCommaFirstNamePostnominal)
{
        EXPECT_THAT(invert("John Smith Sr."), Eq("Smith, John Sr."));
        EXPECT_THAT(invert("Jane Doe MD."), Eq("Doe, Jane MD."));
}

TEST(NameInverterShould, ReturnLastNameCommaFirstNameMultiplePostnominals)
{
        EXPECT_THAT(invert("John Smith Sr. PhD."), Eq("Smith, John Sr. PhD."));
}

int main(int argc, char *argv[]) {
        InitGoogleMock(&argc, argv);
        return RUN_ALL_TESTS();
}
