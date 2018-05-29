import unittest

class PrimeFactors():
    def of(n):
        list = []
        divisor = 2
        while n >= 2:
            while n % divisor == 0:
                list.append(divisor)
                n /= divisor
            divisor += 1
        return list

class PrimeFactororizerShould(unittest.TestCase):
    def test_return_prime_factors_of_integer(self):
            self.assertEqual(PrimeFactors.of(1), [])
            self.assertEqual(PrimeFactors.of(2), [2])
            self.assertEqual(PrimeFactors.of(3), [3])
            self.assertEqual(PrimeFactors.of(4), [2,2])
            self.assertEqual(PrimeFactors.of(5), [5])
            self.assertEqual(PrimeFactors.of(6), [2,3])
            self.assertEqual(PrimeFactors.of(7), [7])
            self.assertEqual(PrimeFactors.of(8), [2,2,2])
            self.assertEqual(PrimeFactors.of(9), [3,3])
            self.assertEqual(PrimeFactors.of(10), [2,5])
