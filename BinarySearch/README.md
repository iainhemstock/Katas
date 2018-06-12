Binary Search Kata
==================

The aim of this kata is to write a function that finds the index of a value
in a sorted list (returning -1 if not present). The algorithm used should be a
binary search (also known as divide and conquer).

https://en.wikipedia.org/wiki/Binary_search_algorithm
From Wikipedia: Binary search works on sorted arrays. Binary search begins by comparing the middle element of the array with the target value. If the target value matches the middle element, its position in the array is returned. If the target value is less than or greater than the middle element, the search continues in the lower or upper half of the array, respectively, eliminating the other half from consideration.

Rules
=====

1: Find index of char in empty list    
find_index_of('a', []) => -1  

2: Find index of char in single item list  
find_index_of('a', ['a']) => 0  

3: Find index of char that is the middle item  
find_index_of('b', ['a', 'b', 'c']) => 1  

4: Find index of char that is in the top half of list  
find_index_of('c', ['a', 'b', 'c']) => 2  

5: Find index of char that is in bottom half of list    
find_index_of('a', ['a', 'b', 'c']) => 0  
