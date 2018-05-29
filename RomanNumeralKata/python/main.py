import unittest

class RomanNumeral():
    dict = {
        "X" : 10,
        "IX" : 9,
        "V" : 5,
        "IV" : 4,
        "I": 1
    }

    def encode(n):
        ret = ""
        for key in RomanNumeral.dict:
            while n >= RomanNumeral.dict[key]:
                ret += key
                n -= RomanNumeral.dict[key]

        return ret

class ConverterShould(unittest.TestCase):
    def test_convert_integer_toroman_numeral(self):
        self.assertEqual(RomanNumeral.encode(1), "I")
        self.assertEqual(RomanNumeral.encode(2), "II")
        self.assertEqual(RomanNumeral.encode(3), "III")
        self.assertEqual(RomanNumeral.encode(4), "IV")
        self.assertEqual(RomanNumeral.encode(5), "V")
        self.assertEqual(RomanNumeral.encode(6), "VI")
        self.assertEqual(RomanNumeral.encode(7), "VII")
        self.assertEqual(RomanNumeral.encode(8), "VIII")
        self.assertEqual(RomanNumeral.encode(9), "IX")
        self.assertEqual(RomanNumeral.encode(10), "X")
        self.assertEqual(RomanNumeral.encode(20), "XX")
        self.assertEqual(RomanNumeral.encode(30), "XXX")
