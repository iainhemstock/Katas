from unittest import TestCase
from MarsRoverController import MarsRoverController

class MarsRoverControllerShould(TestCase):
    def setUp(self):
        self.rover = MarsRoverController()

    def test_rotate_right_once(self):
        self.assertEqual(self.rover.execute('R'), '0:0:E')

    def test_rotate_right_twice(self):
        self.assertEqual(self.rover.execute('RR'), '0:0:S')

    def test_rotate_right_three_times(self):
        self.assertEqual(self.rover.execute('RRR'), '0:0:W')

    def test_rotate_right_four_times(self):
        self.assertEqual(self.rover.execute('RRRR'), '0:0:N')

    def test_rotate_left_once(self):
        self.assertEqual(self.rover.execute('L'), '0:0:W')

    def test_rotate_left_twice(self):
        self.assertEqual(self.rover.execute('LL'), '0:0:S')

    def test_rotate_left_three_times(self):
        self.assertEqual(self.rover.execute('LLL'), '0:0:E')

    def test_rotate_left_four_times(self):
        self.assertEqual(self.rover.execute('LLLL'), '0:0:N')

    def test_move_one_unit_north(self):
        self.assertEqual(self.rover.execute('M'), '0:1:N')

    def test_move_two_units_north(self):
        self.assertEqual(self.rover.execute('MM'), '0:2:N')

    def test_move_wrap_around_when_reaching_north_edge(self):
        self.assertEqual(self.rover.execute('MMMMMMMMMM'), '0:0:N')

    def test_move_one_unit_east(self):
        self.assertEqual(self.rover.execute('RM'), '1:0:E')

    def test_move_two_units_east(self):
        self.assertEqual(self.rover.execute('RMM'), '2:0:E')

    def test_move_wrap_around_when_reaching_east_edge(self):
        self.assertEqual(self.rover.execute('RMMMMMMMMMM'), '0:0:E')

    def test_move_one_unit_south(self):
        self.assertEqual(self.rover.execute('RRM'), '0:9:S')

    def test_move_two_units_south(self):
        self.assertEqual(self.rover.execute('RRMM'), '0:8:S')

    def test_move_wrap_around_when_reaching_south_edge(self):
        self.assertEqual(self.rover.execute('RRM'), '0:9:S')

    def test_move_two_units_west(self):
        self.assertEqual(self.rover.execute('LMM'), '8:0:W')

    def test_move_wrap_around_when_reaching_west_edge(self):
        self.assertEqual(self.rover.execute('LM'), '9:0:W')
