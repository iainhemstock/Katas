class Direction():
    _WESTWARDS = -1

    def __init__(self, defaultDirection='N'):
        self.__currentDirection = defaultDirection
        self.__directions = ['N', 'E', 'S', 'W']
    
    def current(self):
        return self.__currentDirection

    def rotate(self):
        self.__rotate(Direction._WESTWARDS)

    def __rotate(self, rotationDirection):
        index = 0
        for direction in self.__directions:
            if (self.__currentDirection == direction):
                index = (index + rotationDirection) % 4
                self.__currentDirection = self.__directions[index]
                break
            index += 1
