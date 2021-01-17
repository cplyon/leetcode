#! /usr/bin/env python3

# Given n non-negative integers representing an elevation map where the width
# of each bar is 1, compute how much water it can trap after raining.

class Solution:

    def trap3(self, height: list[int]) -> int:
        # O(n^2) where n is len(height)
        if not height or len(height) < 3:
            return 0

        left = 0
        right = len(height)-1
        amount = 0
        floor = 0
        while left < right:
            h = min(height[left], height[right])
            # add water height minus floor between left and right
            for i in range(left+1, right):
                amount += h - max(min(height[i], h), floor)

            # move left or right depending on which bar is lowest
            if height[left] < height[right]:
                while height[left] <= h and left < right:
                    left += 1
            else:
                while height[right] <= h and left < right:
                    right -= 1

            # set new floor, since we accounted for water below this point
            floor = h

        return amount


    def trap(self, height: list[int]) -> int:
        # O(n*m) where n is len(height), m is max(height)
        if not height or len(height) < 3:
            return 0

        rain_collected = 0
        tallest = max(height)

        # iterate values from 1 to tallest
        for i in range(1, tallest+1):
            cur_rain = 0
            block_count = 0
            # iterate height looking for values less than i,
            # and values at least as large as i
            for j in range(len(height)):
                if block_count > 0:
                    if height[j] < i:
                        # since we already found a block, this is a candidate
                        # for trapping rain
                        cur_rain += 1
                    else:
                        # only cash in this rain if we get more than one block
                        block_count += 1
                        rain_collected += cur_rain
                        cur_rain = 0
                else:
                    if height[j] >= i:
                        # this is the first block we found
                        block_count += 1
            if block_count <= 1:
                # stop if we hit a row that has one or no blocks,
                # since no rows above this can trap either
                break
            if block_count == len(height):
                # skip rows that are all blocks
                continue

        return rain_collected

    def trap2(self, height: list[int]) -> int:
        # O(n*m) where n is len(height), m is max(height)

        # build a 2D-array representing blocks, water, and empty spaces
        if not height or len(height) < 3:
            return 0

        BLOCK = "X"
        EMPTY = " "

        grid = []
        blocks = []
        # build the grid, keeping track of the first and last blocks per row
        for i in range(max(height)):
            row = []
            row_blocks = None
            block_count = 0
            for (j, n) in enumerate(height):
                if n > i:
                    row.append(BLOCK)
                    block_count += 1
                    if row_blocks is None:
                        row_blocks = (j, j)
                    else:
                        row_blocks = (row_blocks[0], j)
                else:
                    row.append(EMPTY)

            if block_count <= 1:
                # found a row with one or zero blocks,
                # we can stop looking since no rows above this will
                # be able to trap rain either.
                break
            if block_count == len(height):
                # skip rows that are all blocks
                continue

            # only include rows with potential to trap rain
            grid.append(row)
            blocks.append(row_blocks)

        # make it rain!
        rain_collected = 0
        for i in range(len(grid)):
            row = grid[i]
            # only iterate between the first and the last block
            for j in range(blocks[i][0]+1, blocks[i][1]):
                if row[j] != BLOCK:
                    rain_collected += 1
        return rain_collected


if __name__ == "__main__":
    s = Solution()
    #height = [1, 1, 1, 2, 1, 1, 1, 13, 2, 1, 2, 1]
    #height = [0, 3, 2, 3, 0]
    #height = [0,1,0,2,1,0,1,3,2,1,2,1]
    height = [2,0,2,0,1]
    print(s.trap(height))
    print(s.trap2(height))
    print(s.trap3(height))
