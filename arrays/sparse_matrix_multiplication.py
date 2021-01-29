#! /usr/bin/env python3

class Solution:

    def multiply2(self, A: list[list[int]], B: list[list[int]]) -> list[list[int]]:
        if not A or not B:
            return []

        rows_A = len(A)
        cols_A = len(A[0])
        rows_B = len(B)
        cols_B = len(B[0])

        C = [[0 for row in range(cols_B)] for col in range(rows_A)]

        A_nonzeroes = {}
        for i in range(rows_A):
            for j in range(cols_A):
                if A[i][j] != 0:
                    A_nonzeroes[(i, j)] = A[i][j]

        B_nonzeroes = {}
        for i in range(rows_B):
            for j in range(cols_B):
                if B[i][j] != 0:
                    B_nonzeroes[(i, j)] = B[i][j]

        for a in A_nonzeroes:
            for b in B_nonzeroes:
                if a[1] == b[0]:
                    C[a[0]][b[1]] += A_nonzeroes[a]*B_nonzeroes[b]

        return C

    def multiply1(self, A: list[list[int]], B: list[list[int]]) -> list[list[int]]:
        # O(rows_A*cols_B*colsA)
        if not A or not B:
            return []

        rows_A = len(A)
        cols_A = len(A[0])
        rows_B = len(B)
        cols_B = len(B[0])

        C = [[0 for row in range(cols_B)] for col in range(rows_A)]

        for i in range(rows_A):
            for j in range(cols_B):
                for k in range(cols_A):
                    C[i][j] += A[i][k]*B[k][j]
        return C



if __name__ == "__main__":
    s = Solution()
    A = [
        [ 1, 0, 0],
        [-1, 0, 3]
        ]

    B = [
        [ 7, 0, 0 ],
        [ 0, 0, 0 ],
        [ 0, 0, 1 ]
        ]
    print(s.multiply1(A, B))
    print(s.multiply2(A, B))
