from Move import MoveFactory
from Coordinate import Coordinate

class Buggy():
    def __init__(self, coord, direction):
        self._coord = coord
        self._direction = direction

    def move(self):
        move = MoveFactory().get(self._direction.current())
        move.advance(self._coord)

    def rotate(self):
        self._direction.rotate()

    def status(self):
        return str('{0}:{1}:{2}').format(
            self._coord.x(),
            self._coord.y(),
            self._direction.current()
        )
