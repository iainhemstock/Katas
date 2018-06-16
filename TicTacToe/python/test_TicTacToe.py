from unittest import *
from hamcrest import *
from GameBoard import GameBoard

class GameBoardShould(TestCase):
    def make_gameboard_with_initial_state(self, initialState):
        return GameBoard(initialState)

    def test_that_neither_player_has_won(self):
        gameboard = self.make_gameboard_with_initial_state([
            [' ', ' ', ' '],
            [' ', ' ', ' '],
            [' ', ' ', ' ']
        ])
        assert_that(gameboard.winner(), equal_to(' '))

    def test_that_player_wins_top_left_diagonal(self):
        gameboard = self.make_gameboard_with_initial_state([
            ['X', ' ', ' '],
            [' ', 'X', ' '],
            [' ', ' ', 'X'],
        ])
        assert_that(gameboard.winner(), equal_to('X'))

    def test_that_player_wins_bottom_left_diagonal(self):
        gameboard = self.make_gameboard_with_initial_state([
            [' ', ' ', 'O'],
            [' ', 'O', ' '],
            ['O', ' ', ' '],
        ])
        assert_that(gameboard.winner(), equal_to('O'))

    def test_that_player_wins_first_row(self):
        gameboard = self.make_gameboard_with_initial_state([
            ['O', 'O', 'O'],
            [' ', ' ', ' '],
            [' ', ' ', ' ']
        ])
        assert_that(gameboard.winner(), equal_to('O'))

    def test_that_player_wins_second_row(self):
        gameboard = self.make_gameboard_with_initial_state([
            [' ', ' ', ' '],
            ['X', 'X', 'X'],
            [' ', ' ', ' ']
        ])
        assert_that(gameboard.winner(), equal_to('X'))

    def test_that_player_wins_third_row(self):
        gameboard = self.make_gameboard_with_initial_state([
            [' ', ' ', ' '],
            [' ', ' ', ' '],
            ['O', 'O', 'O']
        ])
        assert_that(gameboard.winner(), equal_to('O'))

    def test_that_player_wins_first_col(self):
        gameboard = self.make_gameboard_with_initial_state([
            ['X', ' ', ' '],
            ['X', ' ', ' '],
            ['X', ' ', ' ']
        ])
        assert_that(gameboard.winner(), equal_to('X'))

    def test_that_player_wins_second_col(self):
        gameboard = self.make_gameboard_with_initial_state([
            [' ', 'O', ' '],
            [' ', 'O', ' '],
            [' ', 'O', ' ']
        ])
        assert_that(gameboard.winner(), equal_to('O'))

    def test_that_player_wins_third_col(self):
        gameboard = self.make_gameboard_with_initial_state([
            [' ', ' ', 'X'],
            [' ', ' ', 'X'],
            [' ', ' ', 'X']
        ])
        assert_that(gameboard.winner(), equal_to('X'))
