#include <gmock/gmock.h>
using namespace ::testing;
#include <vector>
#include <sstream>

class StringCalc
{
public:
        const int add(const std::string& input)
        {
                int ret = 0;
                const std::string delims = "\n,";
                std::vector<int> tokens = split(input, delims);
                for (auto token : tokens)
                        ret += token;
                return ret;
        }
private:
        std::vector<int> split(const std::string& input, const std::string& delims)
        {
                std::vector<int> tokens;
                if (input != "")
                {
                        std::size_t tokenStart = 0;
                        std::size_t found;
                        while((found = input.find_first_of(delims, tokenStart)) != std::string::npos)
                        {
                                tokens.push_back(stringToInt(input.substr(tokenStart, found)));
                                tokenStart = found + 1;
                        }
                        tokens.push_back(stringToInt(input.substr(tokenStart)));
                }
                return tokens;
        }

        const int stringToInt(const std::string& str)
        {
                return std::stoi(str);
        }
};

class StringCalcShould : public Test
{
public:
        StringCalc calc;
};

TEST_F(StringCalcShould, ReturnZeroWhenInputIsEmpty)
{
        EXPECT_THAT(calc.add(""), Eq(0));
}

TEST_F(StringCalcShould, ReturnSameNumberIfOnlyOneNumberIsGiven)
{
        EXPECT_THAT(calc.add("1"), Eq(1));
        EXPECT_THAT(calc.add("2"), Eq(2));
}

TEST_F(StringCalcShould, ReturnSumOfCommaDelimetedNumbers)
{
        EXPECT_THAT(calc.add("1,2"), Eq(3));
        EXPECT_THAT(calc.add("2,3"), Eq(5));
}

TEST_F(StringCalcShould, ReturnSumOfNewLineDelimetedNumbers)
{
        EXPECT_THAT(calc.add("3\n4"), Eq(7));
        EXPECT_THAT(calc.add("4\n5"), Eq(9));
}

TEST_F(StringCalcShould, ReturnSumOfThreeDelimetedNumbers)
{
        EXPECT_THAT(calc.add("4,5,6"), Eq(15));
        EXPECT_THAT(calc.add("5\n6\n7"), Eq(18));
}

int main(int argc, char *argv[]) {
        InitGoogleMock(&argc, argv);
        return RUN_ALL_TESTS();
}
