#!  /usr/bin/env python3

# Given an integer n, return the number of trailing zeroes in n!.
# Follow up: Could you write a solution that works in logarithmic time?
# 1 <= n <= 104
import math


class Solution:

    def trailingZeroes2(self, n: int) -> int:
        zeroes = 0
        while n > 0:
            n //= 5
            zeroes += n
        return zeroes

    def trailingZeroes(self, n: int) -> int:
        if n < 1:
            return 0

        f = math.factorial(n)

        zeroes = 0
        while f % 10 == 0:
            if f % 10 == 0:
                zeroes += 1
            f //= 10

        return zeroes


if __name__ == "__main__":
    s = Solution()
    n = 9999
    print(s.trailingZeroes(n))
    print(s.trailingZeroes2(n))
