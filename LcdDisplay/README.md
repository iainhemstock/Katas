LCD Display
===========

The aim of this kata is to parse a string sequence of digits and return a string that contains an
LCD version of that sequence.

Rules
=====

Write a class called LcdDisplay with a single public method called convert_to_lcd().
An lcd digit should be one unit wide and two units high.   

1: The class should be able to convert a single number
2: The class should be able to convert a multi digit number separated by one column space.
3: Support should be added to scale the size of the digit. By default the digit is 1 unit wide and 2
units high. Pass a scaling value to the method e.g. passing a scaling value of 3 would make the digit
3 units wide and 6 units high.
4: Support should be added to alter the spacing between digits. By default the spacing is set to 1.
Pass a spacing value to the method.

Example
=======

std::string number = "1234567890";   
int scale = 2;  
int space_between_digits = 2  
std::string output = LcdDisplay::convert_to_lcd(number, scale, space_between_digits); // would return a string of:  

        --   --          --    --   --    --    --    --
    |     |    |  |  |  |     |       |  |  |  |  |  |  |
    |     |    |  |  |  |     |       |  |  |  |  |  |  |
        --   --    --    --    --         --    --
    |  |       |     |     |  |  |    |  |  |     |  |  |
    |  |       |     |     |  |  |    |  |  |     |  |  |
        --   --          --    --         --    --    --
