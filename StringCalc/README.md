1: An empty string returns zero
add("") => 0

2: A single number returns the same value
add("1") => 1

3: Two numbers, comma delimited, returns the sum
add("2,3") => 5

4: Two numbers, newline delimited, returns the sum
add("3\n4") => 7

5: Three numbers, delimited either way, returns the sum
add("5,6,7") => 18
add("5\n6\n7") => 18

6: Negative numbers throw an exception
add("-1") => throws exception

7: Numbers greater than 1000 are ignored
add("5,1001,5") => 10
