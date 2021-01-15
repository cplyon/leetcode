#! /usr/bin/env python3
from typing import DefaultDict


class Solution:

    def canCross_dp(self, stones: list[int]) -> bool:
        if not stones or len(stones) < 2 or stones[0] != 0 or stones[1] != 1:
            return False

        # memo holds a set of jump distances from stone i
        # must be a set to avoid duplicate jump distances
        jumps = {}
        jumps[0] = [1]
        for s in stones[1:]:
            jumps[s] = set()

        # create a set of all stones for fast searching
        stone_set = set(stones)

        # for each stone's jump distance,
        # populate the next stone's jump distances (k, k-1, k+1)
        for stone in stones:
            for jump in jumps[stone]:
                next_stone = stone + jump
                if next_stone not in stone_set:
                    # no stone to jump to
                    continue
                if next_stone == stones[-1]:
                    # we can reach the last stone
                    return True
                # add all non-zero jumps from next_stone
                for i in range(-1, 2):
                    if jump + i > 0:
                        jumps[next_stone].add(jump + i)

        # no path to the last stone
        return False


    def canCross_dfs(self, stones: list[int]) -> bool:
        if not stones or len(stones) < 2 or stones[0] != 0 or stones[1] != 1:
            return False

        stone_set = set(stones)
        stack = []
        # store stone and k to get to stone
        stack.insert(0, (1, 1))
        while len(stack) > 0:
            stone, k = stack.pop()
            if stone == stones[-1]:
                return True
            if stone > stones[-1]:
                continue

            for i in range(-1, 2):
                next_stone = stone+k+i
                if k+i > 0 and next_stone in stone_set:
                    stack.insert(0, (next_stone, k+i))

        return False

    def canCross_bfs(self, stones: list[int]) -> bool:
        if not stones or len(stones) < 2 or stones[0] != 0 or stones[1] != 1:
            return False

        stone_set = set(stones)
        queue = []
        # store stone and k to get to stone
        queue.append((1, 1))
        while len(queue) > 0:
            stone, k = queue.pop()
            if stone == stones[-1]:
                return True
            if stone > stones[-1]:
                return False

            for i in range(-1, 2):
                next_stone = stone+k+i
                if k+i > 0 and next_stone in stone_set:
                    queue.append((next_stone, k+i))

        return False


    def canCross(self, stones: list[int]) -> bool:
        if not stones or len(stones) < 2 or stones[0] != 0 or stones[1] != 1:
            return False

        # Map stones to the costs of jumps that can be made.
        costs = {}
        # From the stone '0', we can only go to '1' at a cost of 1
        costs[0] = [1]
        for stone in stones[1:]:
            costs[stone] = set()

        # Map stones to their sources. Use a set to avoid duplicates.
        sources = DefaultDict(set)
        # No way to get to stone '0'
        sources[0] = set()
        # The only way to get to the stone '1' is from stone '0'
        sources[1] = {0}

        for stone in stones[1:]:
            for src in sources[stone]:
                for cost in costs[src]:
                    dest = cost + src
                    if dest == stone:
                        for k in range(-1, 2):
                            if dest+cost+k == stones[-1]:
                                # we found a path to the final stone!
                                return True
                            if dest+cost+k != dest:
                                # don't add duplicates
                                costs[stone].add(cost+k)
                                sources[dest+cost+k].add(stone)

        # no path to the final stone
        return False


if __name__ == "__main__":
    s = Solution()
    #stones = [0,1,3,5,6,8,12,17]
    #stones = [0,1,3,6,10,15,21,29]
    #stones = [0,1,2,3,4,5]
    stones = [0,1,2,3,4,8,9,11]
    print(s.canCross(stones))
    print(s.canCross_bfs(stones))
    print(s.canCross_dfs(stones))
    print(s.canCross_dp(stones))
