#! /usr/bin/env python3

class Solution:
    def isPowerOfTwo(self, n: int) -> bool:
        return n in {2**x for x in range(32)}


if __name__ == "__main__":
    s = Solution()
    n = 16
    print(s.isPowerOfTwo(n))
