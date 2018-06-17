class MoveFactory:
    def get(self, direction):
        if direction == 'N': return MoveVertically(1)
        if direction == 'S': return MoveVertically(-1)
        if direction == 'E': return MoveHorizontally(1)
        if direction == 'W': return MoveHorizontally(-1)

class Move:
    def advance(self, amount):
        raise NotImplementedError()

class MoveHorizontally(Move):
    def __init__(self, amount):
        self._amount = amount

    def advance(self, coord):
        coord.advanceHorizontallyBy(self._amount)

class MoveVertically(Move):
    def __init__(self, amount):
        self._amount = amount

    def advance(self, coord):
        coord.advanceVerticallyBy(self._amount)
