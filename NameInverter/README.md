====================================================================================================
Name Inverter Kata
====================================================================================================

This kata is an exercise in refactoring. A name is passed to a function which returns it in inverted
form. For example, "John Smith" would become "Smith, John".
A name can contain an honorific such as "Mr." or "Mrs." as well as multiple post-nominals such as
"Dr." or "PhD".

The returned string should be in the form:
<last-name><comma> <first-name> <opt-honorofic> <opt-postnominal-1> <opt-postnominal-2> ...

====================================================================================================
Rules:
====================================================================================================
The function should be defined as:
const std::string invert(const std::string& name)

1: Given an empty name the returned string should be an empty string
invert("") => ""

2: Given a single name the returned string should be that name
invert("John") => "John"

3: Given a first and last name, the returned string must be inverted
invert("John Smith") => "Smith, John"

4: Given a name containing an honorific it should be ignored
invert("Mr. John Smith") => "Smith, John"

5a: Given a name containing a post-nominal it should still appear at the end of the name
invert("John Smith Sr.") => "Smith, John Sr."

5b: Given a name containing multiple post-nominals they should appear at the end of the name
invert("John Smith Sr. PhD.") => "Smith, John Sr. PhD."
