#! /usr/bin/env python3

class Solution:
    def numSquares(self, n: int) -> int:
        # Dynamic Programming approach
        # O(n*m) where m is the number of squares less than n
        MAX = 10000
        if n < 1 or n > MAX:
            return 0

        # store all perfect squares until min(n^2, MAX)
        squares = []  # use a list for ordered iteration
        squares_set = set()  # use a set for fast lookup
        for i in range(1, min(n, 100)+1):
            square = i*i
            if n == square:
                # bail out early
                return 1
            squares.append(square)
            squares_set.add(square)

        # base case: set perfect squares to 1, all other values to 0
        memo = [1 if i in squares_set else 0 for i in range(0, n+1)]

        # calculate number of perfect squares that sum to n
        for i in range(2, n+1):
            cur_min = MAX+1
            j = 0
            while squares[j] <= i:
                cur_min = min(cur_min, memo[i-squares[j]])
                j += 1
            memo[i] = cur_min+1

        return memo[-1]


if __name__ == "__main__":
    s = Solution()
    n = 999
    print(s.numSquares(n))
