#include <gmock/gmock.h>
using namespace ::testing;
#include <list>
using IntList = std::list<int>;

class PrimeFactors
{
public:
        static const IntList of(int n)
        {
                IntList list;
                for (int divisor = 2; n >= 2; ++divisor)
                        for (; n % divisor == 0; n /= divisor)
                                list.push_back(divisor);

                return list;
        }
};

TEST(GeneratorShould, ReturnPrimeFactorsOfInteger)
{
        EXPECT_THAT(PrimeFactors::of(2*2*2*3*5*5*7*11*13), Eq(IntList{{2,2,2,3,5,5,7,11,13}}));
        EXPECT_THAT(PrimeFactors::of(1), Eq(IntList{}));
        EXPECT_THAT(PrimeFactors::of(2), Eq(IntList{ 2 }));
        EXPECT_THAT(PrimeFactors::of(3), Eq(IntList{ 3 }));
        EXPECT_THAT(PrimeFactors::of(4), Eq(IntList{ 2, 2 }));
        EXPECT_THAT(PrimeFactors::of(5), Eq(IntList{ 5 }));
        EXPECT_THAT(PrimeFactors::of(6), Eq(IntList{ 2, 3 }));
        EXPECT_THAT(PrimeFactors::of(7), Eq(IntList{ 7 }));
        EXPECT_THAT(PrimeFactors::of(8), Eq(IntList{ 2, 2, 2 }));
        EXPECT_THAT(PrimeFactors::of(9), Eq(IntList{ 3, 3 }));
}

int main(int argc, char *argv[]) {
        InitGoogleMock(&argc, argv);
        return RUN_ALL_TESTS();
}
