class Coordinate():
    GRID_MAX = 10

    def __init__(self, x=0, y=0):
        self.__x = x
        self.__y = y

    def x(self):
        return self.__x

    def y(self):
        return self.__y

    def move(self, direction):
        if direction.current() == 'N': self.__advanceVerticallyBy(1)
        elif direction.current() == 'S': self.__advanceVerticallyBy(-1)
        elif direction.current() == 'E': self.__advanceHorizontallyBy(1)
        elif direction.current() == 'W': self.__advanceHorizontallyBy(-1)

    def __advanceVerticallyBy(self, amount):
        self.__y = (self.__y + amount) % Coordinate.GRID_MAX

    def __advanceHorizontallyBy(self, amount):
        self.__x = (self.__x + amount) % Coordinate.GRID_MAX
