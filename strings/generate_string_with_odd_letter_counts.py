#! /usr/bin/env python3

class Solution:
    def generateTheString(self, n: int) -> str:
        if n < 1:
            return ""

        return "a" * n if n % 2 == 1 else "a" * (n-1) + "b"


if __name__ == "__main__":
    s = Solution()
    n = 4
    print(s.generateTheString(n))
