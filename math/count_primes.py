#! /usr/bin/env python3

from math import sqrt


class Solution:

    def countPrimes(self, n: int) -> int:
        prime_count = 0
        primes = [True] * n
        for i in range(2, n):
            if primes[i]:
                prime_count += 1
            j = 2
            while i*j < n:
                primes[i*j] = False
                j += 1

        return prime_count


if __name__ == "__main__":
    s = Solution()
    n = 149
    print(s.countPrimes(n))
