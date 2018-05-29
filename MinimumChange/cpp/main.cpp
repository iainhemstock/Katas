#include <gmock/gmock.h>
using namespace ::testing;
#include <sstream>
#include <vector>

class ChangeMaker
{
public:
        const std::vector<int> makeChange(int amount)
        {
                std::vector<int> coinStack;
                std::vector<int> coins{1, 2, 5, 10, 20, 50, 100, 200};
                std::map<int, int> coinCount;
                for (auto coin : coins)
                        coinCount[coin] = 0;
                auto result = makeChange_recursion(amount, --coins.cend(), coinStack, coinCount);

                std::vector<std::string> statements;
                for (auto coin = coins.rbegin(); coin != coins.rend(); ++coin)
                {
                        std::stringstream ss;
                        ss << amount << " = ";
                        if (coinCount[*coin] != 0)
                        {
                                ss << coinCount[*coin] << " x " << *coin << "p coin";
                                statements.push_back(std::string{ss.str()});
                        }
                }

                for (auto statement = statements.cbegin(); statement != statements.cend(); ++statement)
                {
                        std::cout << *statement << std::endl;
                }

                return result;
        }
private:
        std::vector<int> makeChange_recursion(int amount, std::vector<int>::const_iterator currentCoin,
                std::vector<int>& coinStack, std::map<int, int>& coinCount)
        {
                if (amount <= 0) return coinStack;

                while (amount >= *currentCoin)
                {
                        ++coinCount[*currentCoin];
                        coinStack.push_back(*currentCoin);
                        amount -= *currentCoin;
                }

                return makeChange_recursion(amount, --currentCoin, coinStack, coinCount);
        }
};

TEST(ChangeMakerShould, ReturnMinimumCoinsForPenniesAmount)
{
        ChangeMaker cm;
        EXPECT_THAT(cm.makeChange(0), Eq(std::vector<int>{}));
        EXPECT_THAT(cm.makeChange(1), Eq(std::vector<int>{1}));
        EXPECT_THAT(cm.makeChange(2), Eq(std::vector<int>{2}));
        EXPECT_THAT(cm.makeChange(3), Eq(std::vector<int>{2,1}));
        EXPECT_THAT(cm.makeChange(5), Eq(std::vector<int>{5}));
        EXPECT_THAT(cm.makeChange(7), Eq(std::vector<int>{5,2}));
        EXPECT_THAT(cm.makeChange(10), Eq(std::vector<int>{10}));
        EXPECT_THAT(cm.makeChange(15), Eq(std::vector<int>{10,5}));
        EXPECT_THAT(cm.makeChange(20), Eq(std::vector<int>{20}));
        EXPECT_THAT(cm.makeChange(30), Eq(std::vector<int>{20,10}));
        EXPECT_THAT(cm.makeChange(50), Eq(std::vector<int>{50}));
        EXPECT_THAT(cm.makeChange(70), Eq(std::vector<int>{50,20}));
        EXPECT_THAT(cm.makeChange(100), Eq(std::vector<int>{100}));
        EXPECT_THAT(cm.makeChange(150), Eq(std::vector<int>{100,50}));
        EXPECT_THAT(cm.makeChange(200), Eq(std::vector<int>{200}));
        EXPECT_THAT(cm.makeChange(300), Eq(std::vector<int>{200,100}));
        EXPECT_THAT(cm.makeChange(388), Eq(std::vector<int>{200,100,50,20,10,5,2,1}));
        EXPECT_THAT(cm.makeChange(400), Eq(std::vector<int>{200,200}));
        EXPECT_THAT(cm.makeChange(600), Eq(std::vector<int>{200,200,200}));
}

int main(int argc, char *argv[]) {
        InitGoogleMock(&argc, argv);
        return RUN_ALL_TESTS();
}
