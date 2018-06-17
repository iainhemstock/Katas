from Move import MoveFactory

class Coordinate():
    GRID_MAX = 10

    def __init__(self, x=0, y=0):
        self.__x = x
        self.__y = y

    def x(self):
        return self.__x

    def y(self):
        return self.__y

    def advanceVerticallyBy(self, amount):
        self.__y = (self.__y + amount) % Coordinate.GRID_MAX

    def advanceHorizontallyBy(self, amount):
        self.__x = (self.__x + amount) % Coordinate.GRID_MAX
