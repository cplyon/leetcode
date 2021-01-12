#! /usr/bin/env python3

class Solution:

    def spiralOrder(self, matrix: list[list[int]]) -> list[int]:
        # O(n) time O(n) space
        if not matrix or not matrix[0]:
            return []

        n = len(matrix[0])
        m = len(matrix)
        visited = set()
        spiral = []
        i = -1
        j = -1
        size = n*m

        while len(visited) < size:
            # go right
            i += 1
            j += 1
            while i < n and (j, i) not in visited:
                spiral.append(matrix[j][i])
                visited.add((j, i))
                i += 1

            # go down
            i -= 1
            j += 1
            while j < m and (j, i) not in visited:
                spiral.append(matrix[j][i])
                visited.add((j, i))
                j += 1

            # go left
            j -= 1
            i -= 1
            while i >= 0 and (j, i) not in visited:
                spiral.append(matrix[j][i])
                visited.add((j, i))
                i -= 1

            # go up
            i += 1
            j -= 1
            while j >= 0 and (j, i) not in visited:
                spiral.append(matrix[j][i])
                visited.add((j, i))
                j -= 1

        return spiral


if __name__ == "__main__":
    s = Solution()
    matrix = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
    print(s.spiralOrder(matrix))
