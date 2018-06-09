from lcd_digits import one, two, three, four, five, six, seven, eight, nine, zero

def parse(input):
    switcher = {
        "1" : one,
        "2" : two,
        "3" : three,
        "4" : four,
        "5" : five,
        "6" : six,
        "7" : seven,
        "8" : eight,
        "9" : nine,
        "0" : zero
    }
    lcd_digits = []
    for char in input:
        lcd_digits.append(switcher.get(char))

    return lcd_digits

def buildOutput(lcd_digits, spacing):
    output = ""
    digit_height = len(lcd_digits[0]) if len(lcd_digits) >= 1 else 0
    for i in range(digit_height):
        for digit in lcd_digits:
            output += digit[i] + (' ' * spacing)
        output += "\n"
    return output

def convertToLcd(input, spacing):
    lcd_digits = parse(input)
    return buildOutput(lcd_digits, spacing)

def main():
    number = input("Enter a number:")
    spacing = int(input("Enter spacing:"))
    print (convertToLcd(number, spacing))

if __name__ == "__main__":
    main()
