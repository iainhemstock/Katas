#include <gmock/gmock.h>
using namespace ::testing;

class Game
{
public:
        const std::string output(const int number)
        {
                std::stringstream ss;

                if (isExactlyDivisbleByThree(number)) ss << "fizz";
                if (isExactlyDivisbleByFive(number)) ss << "buzz";
                if (ss.str() == "") ss << number;
                return ss.str();
        }
private:
        const bool isExactlyDivisbleByThree(const int number) { return number % 3 == 0; }
        const bool isExactlyDivisbleByFive(const int number) { return number % 5 == 0; }
};

class GameShould : public Test
{
public:
        Game game;
};

TEST_F(GameShould, ReturnOutputForNumber)
{
        EXPECT_THAT(game.output(1), Eq("1"));
        EXPECT_THAT(game.output(2), Eq("2"));
        EXPECT_THAT(game.output(3), Eq("fizz"));
        EXPECT_THAT(game.output(4), Eq("4"));
        EXPECT_THAT(game.output(5), Eq("buzz"));
        EXPECT_THAT(game.output(6), Eq("fizz"));
        EXPECT_THAT(game.output(9), Eq("fizz"));
        EXPECT_THAT(game.output(10), Eq("buzz"));
        EXPECT_THAT(game.output(15), Eq("fizzbuzz"));
        EXPECT_THAT(game.output(20), Eq("buzz"));
        EXPECT_THAT(game.output(21), Eq("fizz"));
        EXPECT_THAT(game.output(22), Eq("22"));
        EXPECT_THAT(game.output(30), Eq("fizzbuzz"));
}

int main(int argc, char *argv[]) {
        Game game;
        for (auto i = 1; i <= 100; ++i)
                std::cout << game.output(i) << "\n";

        InitGoogleMock(&argc, argv);
        return RUN_ALL_TESTS();
}
