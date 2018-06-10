from Direction import Direction
from Coordinate import Coordinate

class MarsRover():
    def execute(self, commandSequence):
        coord = Coordinate(0,0)
        direction = Direction('N')

        for command in commandSequence:
            if command == 'M': coord.move(direction)
            elif command == 'R': direction.rotateRight()
            elif command == 'L': direction.rotateLeft()

        return str('{0}:{1}:{2}').format(
            coord.x(),
            coord.y(),
            direction.current()
        )
