#! /usr/bin/env python3

from math import sqrt


class Solution:
    def checkPerfectNumber(self, num: int) -> bool:
        if num == 1:
            return False
        sum = 1
        for i in range(int(sqrt(num)), 1, -1):
            if num % i == 0:
                sum += i
                sum += num // i
            if sum > num:
                return False
        return sum == num


if __name__ == "__main__":
    s = Solution()
    num = 28
    print(s.checkPerfectNumber(num))
