class Direction():
    __EASTWARDS = 1
    __WESTWARDS = -1

    def __init__(self, defaultDirection='N'):
        self.__currentDirection = defaultDirection
        self.__directions = ['N', 'E', 'S', 'W']

    def rotateRight(self):
        self.__rotate(Direction.__EASTWARDS)

    def rotateLeft(self):
        self.__rotate(Direction.__WESTWARDS)

    def __rotate(self, rotationDirection):
        index = 0
        for direction in self.__directions:
            if (self.__currentDirection == direction):
                index = (index + rotationDirection) % 4
                self.__currentDirection = self.__directions[index]
                break
            index += 1

    def current(self):
        return self.__currentDirection
