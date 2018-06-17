from Direction import Direction
from Coordinate import Coordinate
from Commands import *
from Buggy import Buggy

class MarsRoverController():
    def __init__(self):
        self._buggy = Buggy(Coordinate(0,0), Direction('N'))

    def execute(self, commandSequence):
        for command in commandSequence:
            cmd = CommandFactory().get(command)
            cmd.execute(self._buggy)

        return self._buggy.status()
