#include <gmock/gmock.h>
using namespace ::testing;

// F0	F1	F2	F3	F4	F5	F6	F7	F8	F9	F10	F11	F12	F13	F14	F15	F16	F17	F18	F19	F20
// 0	1	1	2	3	5	8	13	21	34	55	89	144	233	377	610	987	1597	2584	4181	6765

const int fib(const int n)
{
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fib(n-2) + fib(n-1);
}

TEST(FibShould, ReturnNthNumberInSequence)
{
        EXPECT_THAT(fib(0), Eq(0));
        EXPECT_THAT(fib(1), Eq(1));
        EXPECT_THAT(fib(2), Eq(1));
        EXPECT_THAT(fib(3), Eq(2));
        EXPECT_THAT(fib(10), Eq(55));
        EXPECT_THAT(fib(20), Eq(6765));
}

int main(int argc, char *argv[]) {
        InitGoogleMock(&argc, argv);
        return RUN_ALL_TESTS();
}
