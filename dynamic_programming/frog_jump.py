#! /usr/bin/env python3
from typing import DefaultDict


class Solution:
    def canCross(self, stones: list[int]) -> bool:
        if not stones or len(stones) < 1 or stones[0] != 0:
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
    stones = [0,1,3,5,6,8,12,17]
    #stones = [0,1,3,6,10,15,21,29]
    #stones = [0,1,2,3,4,5]
    #stones = [0,1,2,3,4,8,9,11]
    print(s.canCross(stones))
