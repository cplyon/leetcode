#!  /usr/bin/env python3

class Solution:

    def __init__(self):
        self.seen = {}
        self.outgoing = {}

    def getKth(self, lo: int, hi: int, k: int) -> int:
        # naive, math-based approach
        if lo < 1 or lo > hi or hi > 1000:
            return -1
        if k < 1 or k > hi - lo + 1:
            return -1

        results = {}
        for i in range(lo, hi+1):
            x = i
            count = 0
            while x != 1:
                c, x = self.even(x)
                count += c
                if x == 1:
                    break
                c, x = self.odd(x)
                count += c
            results[i] = count

        return [i for (i, x) in sorted(results.items(), key=lambda x: x[1])][k-1]

    def even(self, x: int) -> tuple[int, int]:
        count = 0
        while x % 2 == 0 and x != 0:
            x = x // 2
            count += 1
        return (count, x)

    def odd(self, x: int) -> tuple[int, int]:
        count = 0
        while x % 2 != 0:
            x = x*3+1
            count += 1
        return (count, x)

    def getKth2(self, lo: int, hi: int, k: int) -> int:
        # memoized approach
        if lo < 1 or lo > hi or hi > 1000:
            return -1
        if k < 1 or k > hi - lo + 1:
            return -1

        memo = {}
        memo[1] = 1

        def calculate(n: int) -> int:
            if n not in memo:
                if n % 2 == 0:
                    memo[n] = 1 + calculate(n // 2)
                else:
                    memo[n] = 1 + calculate(n*3+1)
            return memo[n]

        results = {}
        for i in range(lo, hi+1):
            results[i] = calculate(i)
        return sorted(results.items(), key=lambda x: x[1])[k-1][0]


if __name__ == "__main__":
    s = Solution()
    lo = 12
    hi = 15
    k = 2
    print(s.getKth(lo, hi, k))
    print(s.getKth2(lo, hi, k))
