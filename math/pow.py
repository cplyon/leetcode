#! /usr/local/bin/python3

class Solution:

    def myPow_iterative(self, x: float, n: int) -> float:
        if x == 0.0:
            return 0.0
        if n < 0:
            x = float(1.0 / x)
            n = -n

        result = 1.0
        for _ in range(0, n):
            result *= x

        return result

    def myPow_iterative2(self, x: float, n: int) -> float:
        if x == 0.0:
            return 0.0
        if n < 0:
            x = float(1.0 / x)
            n = -n
        elif n == 0:
            return 1.0

        result = 1.0
        for _ in range(0, n//2):
            result *= x

        # x^n = (x*x)^(n/2)
        if n % 2 == 0:
            return result*result
        return result*result*x

    def myPow_recursive(self, x: float, n: int) -> float:
        if x == 0.0:
            return 0.0
        if n < 0:
            x = float(1.0 / x)
            n = -n
        elif n == 0:
            return 1.0

        return x * self.myPow_recursive(x, n-1)

    def myPow_recursive2(self, x: float, n: int) -> float:
        if x == 0.0:
            return 0.0
        if n < 0:
            x = float(1.0 / x)
            n = -n
        elif n == 0:
            return 1.0

        result = self.myPow_recursive2(x, (n//2))
        if n % 2 == 0:
            return result*result
        else:
            return result*result*x

    def myPow_dp(self, x: float, n: int) -> float:
        if x == 0.0:
            return 0.0
        if n < 0:
            x = float(1.0 / x)
            n = -n

        memo = []
        memo.append(1.0)
        memo.append(x)

        for i in range(2, n+1):
            memo.append(float(x*memo[i-1]))

        return memo[n]


if __name__ == "__main__":
    s = Solution()
    x = 1.02
    n = -1
    print(s.myPow_iterative(x, n))
    print(s.myPow_iterative2(x, n))
    print(s.myPow_recursive(x, n))
    print(s.myPow_recursive2(x, n))
    print(s.myPow_dp(x, n))
