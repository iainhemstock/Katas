#===================================================================================================
#===================================================================================================
class GameBoardImpl:
    NO_WINNER_TOKEN = ' '
    NUM_ROWS = 3

    def __init__(self, initialState):
        self._table = initialState

    def setCell(self, row, col, token):
        self._table[row][col] = token

    def cell(self, row, col):
        return self._table[row][col]

    def player_has_won_diagonal(self):
        if self._player_has_won_top_left_diagonal() or self._player_has_won_bottom_left_diagonal():
            return True
        return False

    def _player_has_won_top_left_diagonal(self):
        cell_a = self.cell(0, 0)
        cell_b = self.cell(1, 1)
        cell_c = self.cell(2, 2)
        return self._validate_consecutive_cells(cell_a, cell_b, cell_c)

    def _player_has_won_bottom_left_diagonal(self):
        cell_a = self.cell(2, 0)
        cell_b = self.cell(1, 1)
        cell_c = self.cell(0, 2)
        return self._validate_consecutive_cells(cell_a, cell_b, cell_c)

    def player_has_won_row_or_col(self, i):
        if self._player_has_won_row(i) or self._player_has_won_col(i): return True
        return False

    def _player_has_won_row(self, row):
        cell_a = self._table[row][0]
        cell_b = self._table[row][1]
        cell_c = self._table[row][2]
        return self._validate_consecutive_cells(cell_a, cell_b, cell_c)

    def _player_has_won_col(self, col):
        cell_a = self._table[0][col]
        cell_b = self._table[1][col]
        cell_c = self._table[2][col]
        return self._validate_consecutive_cells(cell_a, cell_b, cell_c)

    def _validate_consecutive_cells(self, cell_a, cell_b, cell_c):
        if self._all_tokens_match(cell_a, cell_b, cell_c):
            if self._cell_contains_player_token(cell_a): return True
        return False

    def _all_tokens_match(self, cell_a, cell_b, cell_c):
        return cell_a == cell_b and cell_b == cell_c

    def _cell_contains_player_token(self, cell):
        return cell != self.NO_WINNER_TOKEN
#===================================================================================================
#===================================================================================================
class GameBoard:
    def __init__(self, initialState = None):
        if initialState == None:
            initialState = [
                [ ' ', ' ', ' '],
                [ ' ', ' ', ' '],
                [ ' ', ' ', ' ']
            ]

        self._impl = GameBoardImpl(initialState)

    def turn(self, playerToken, row, col):
        self._impl.setCell(row, col, playerToken)

    def winner(self):
        winningPlayerToken = self._impl.NO_WINNER_TOKEN

        for i in range(0, self._impl.NUM_ROWS):
            if self._impl.player_has_won_row_or_col(i):
                winningPlayerToken = self._impl.cell(i, i)

        if self._impl.player_has_won_diagonal():
            winningPlayerToken = self._impl.cell(1, 1)

        return winningPlayerToken
