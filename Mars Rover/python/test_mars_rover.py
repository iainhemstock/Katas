from unittest import TestCase
from MarsRover import MarsRover

class MarsRoverShould(TestCase):
    def setUp(self):
        self.rover = MarsRover()

    def test_rotate_right_once(self):
        self.assertEqual(self.rover.execute('R'), '0:0:E')

    def test_rotate_right_twice(self):
        self.assertEqual(self.rover.execute('RR'), '0:0:S')

    def test_rotate_right_three_times(self):
        self.assertEqual(self.rover.execute('RRR'), '0:0:W')

    def test_rotate_right_four_times(self):
        self.assertEqual(self.rover.execute('RRRR'), '0:0:N')

    # def test_rotate_left_once(self):
    #     self.assertEqual(self.rover.execute('L'), '0:0:W')
    #
    # def test_rotate_left_twice(self):
    #     self.assertEqual(self.rover.execute('LL'), '0:0:S')
    #
    # def test_rotate_left_three_times(self):
    #     self.assertEqual(self.rover.execute('LLL'), '0:0:E')
    #
    # def test_rotate_left_four_times(self):
    #     self.assertEqual(self.rover.execute('LLLL'), '0:0:N')
