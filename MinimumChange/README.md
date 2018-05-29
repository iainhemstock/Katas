Minimum Coin Change Kata (Easy Version)
=======================================

The aim of this kata is to write a function that returns a list of the minimum number of coins that
a monetary value can be represented as. All values are represented in pennies. This can be solved
using an iterative or recursive approach. Once completed, refactor the code using the opposite approach.

const std::list<int> makeChange(int pennies)

Examples:
-
Using coins in British currency - [200,100,50,20,10,5,2,1]
makeChange(0) => []
makeChange(1) => [1]
makeChange(5) => [5]
makeChange(6) => [5,1]
makeChange(9) => [5,2,2]
makeChange(99) => [50,20,20,5,2,2]
makeChange(128) => [100,20,5,2,1]
makeChange(388) => [200,100,50,20,10,5,2,1]




Minimum Coin Change Kata (Advanced Version)
===========================================
Adapted from https://www.codewars.com/kata/minimum-number-of-coins

The aim of this kata is to write a function that when given a monetary amount it will return how
that amount could be represented in the least number of coins.

const std::string makeChange(const std::string& money)
const std::string makeChange(const int money)
const std::string makeChange(const float money)

The amount can be specified as a string or number (int or floating point). If the amount starts with
a '£' or is a floating point number then it should be assumed that the amount is in pounds. All other
cases it should be assumed the amount is in pennies.

Output
======
The output of the function should be a string that lists the number of each coin from highest worth
to lowest comma delimeted. If more than one coin is required to make change then there should be an
'and' in the string before the last coin.

makeChange("50p") => "1 x 50p"
makeChange(50) => "1 x 50p"
makeChange("60p") => "1 x 50p and 1 x 10p"
makeChange(75) => "1 x 50p, 1 x 20p and 1 x 5p"
makeChange(1.17) => "1 x £1, 1 x 10p, 1 x 5p and 1 x 2p"
makeChange("£4.99") => "2 x £2, 1 x 50p, 2 x 20p, 1 x 5p and 2 x 2p"

Invalid Input
=============
The input string should follow a strict format. If the string starts with a '£' then it should not end
with a 'p'. Any misplaced chars will also be considered an error. In the case of invalid input then
an InvalidInputException should be thrown.

makeChange("2£2")
makeChange("20pp")
makeChange("-45p")
makeChange("£45£")
makeChange("4.2.")
makeChange("2£0p")
