#! /usr/bin/env python3

class Solution:
    def numSquares(self, n: int) -> int:
        MAX = 10000
        if n < 1 or n > 10000:
            return 0

        squares = set([x*x for x in range(1, 101)])
        memo = [1 if i in squares else 0 for i in range(0, n+1)]

        for i in range(2, n+1):
            cur_min = MAX+1
            for s in squares:
                if s <= i:
                    cur_min = min(cur_min, memo[i-s])
            if cur_min <= MAX:
                memo[i] = cur_min+1

        return memo[-1]


if __name__ == "__main__":
    s = Solution()
    n = 1911
    print(s.numSquares(n))
