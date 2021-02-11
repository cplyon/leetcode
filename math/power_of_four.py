#! /usr/bin/env python3

class Solution:
    def isPowerOfFour(self, n: int) -> bool:
        return n in {4**x for x in range(32)}


if __name__ == "__main__":
    s = Solution()
    n = 16
    print(s.isPowerOfFour(n))
