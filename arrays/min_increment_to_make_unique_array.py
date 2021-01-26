#! /usr/bin/env python3

class Solution:
    def minIncrementForUnique(self, A: list[int]) -> int:
        if not list:
            return 0
        counts = {}
        for n in A:
            if n not in counts:
                counts[n] = 0
            counts[n] += 1

        moves = 0
        sum = 0
        while sum != len(A):
            sum = 0
            for n in sorted(counts):
                sum += 1
                i = 1
                while counts[n] > 1:
                    counts[n] -= 1
                    if n+i not in counts:
                        counts[n+i] = 0
                    counts[n+i] += 1
                    moves += i
                    i += 1
                    sum = 0

        return moves


if __name__ == "__main__":
    s = Solution()
    A = [2,2,2,2,2,2,22,2,2]
    print(s.minIncrementForUnique(A))
