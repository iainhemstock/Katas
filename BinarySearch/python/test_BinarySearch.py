from unittest import TestCase
from BinarySearch import find_index_of

class BinarySearchShould(TestCase):
    def test_return_neg_one_when_source_list_is_empty(self):
        expected = -1
        actual = find_index_of('a', [])
        self.assertEqual(actual, expected)

    def test_should_return_zero_when_value_is_present_in_single_item_list(self):
        expected = 0
        actual = find_index_of('a', ['a'])
        self.assertEqual(actual, expected)

    def test_should_return_one_when_value_is_midpoint_in_size_three_list(self):
        expected = 1
        actual = find_index_of('b', ['a', 'b', 'c'])
        self.assertEqual(actual, expected)

    def test_should_return_two_when_value_is_midpoint_of_top_half_of_list(self):
        expected = 2
        actual = find_index_of('c', ['a', 'b', 'c'])
        self.assertEqual(actual, expected)

    def test_should_return_zero_when_value_is_midpoint_of_bottom_half_of_list(self):
        expected = 0
        actual = find_index_of('a', ['a', 'b', 'c', 'd', 'e'])
        self.assertEqual(actual, expected)
