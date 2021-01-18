#! /usr/bin/env python3

class Solution:
    def kthSmallest(self, matrix: list[list[int]], k: int) -> int:
        # n = # elements in the array
        # O(nlgn) time, O(n) space
        if not matrix or not matrix[0] or k <= 0:
            return -1

        n = len(matrix)
        m = len(matrix[0])
        return sorted([matrix[i][j] for i in range(n) for j in range(m)])[k-1]


if __name__ == "__main__":
    s = Solution()
    matrix = [  [1,5,9],
                [10,11,13],
                [12,13,15]
                ]
    for k in range(1,10):
        print(k, s.kthSmallest(matrix, k))
