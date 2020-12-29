#! /usr/bin/env python3

# Given an m x n 2d grid map of '1's (land) and '0's (water),
# return the number of islands.

# An island is surrounded by water and is formed by connecting
# adjacent lands horizontally or vertically. You may assume all
# four edges of the grid are all surrounded by water.

class Solution:

    def __init__(self):
        self.visited = set()

    def numIslands(self, grid: list[list[str]]) -> int:
        if not grid:
            return 0

        island_count = 0
        for i in range(len(grid)):
            for j in range(len(grid[i])):
                if grid[i][j] == "1" and (i, j) not in self.visited:
                    self.check_adjacents(grid, i, j)
                    island_count += 1

        return island_count

    def check_adjacents(self, grid: list[list[str]], i: int, j: int):
        if i >= len(grid) or i < 0 or j >= len(grid[0]) or j < 0 or \
                (i, j) in self.visited or grid[i][j] != "1":
            return
        self.visited.add((i, j))
        self.check_adjacents(grid, i+1, j)
        self.check_adjacents(grid, i-1, j)
        self.check_adjacents(grid, i, j+1)
        self.check_adjacents(grid, i, j-1)


if __name__ == "__main__":
    s = Solution()
    grid = [
        ["1", "1", "1", "1", "0"],
        ["0", "0", "0", "1", "0"],
        ["1", "1", "0", "0", "0"],
        ["0", "0", "0", "0", "0"]
    ]
    print(s.numIslands(grid))
