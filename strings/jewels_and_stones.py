#! /usr/bin/env python3

class Solution:
    def numJewelsInStones(self, jewels: str, stones: str) -> int:
        # O(j+s)
        if not jewels or not stones:
            return 0

        stone_counts = {}
        for s in stones:
            if s not in stone_counts:
                stone_counts[s] = 0
            stone_counts[s] += 1

        jewel_count = 0
        for j in jewels:
            if j in stone_counts:
                jewel_count += stone_counts[j]

        return jewel_count

    def numJewelsInStones2(self, jewels: str, stones: str) -> int:
        # O(s+j)
        if not jewels or not stones:
            return 0

        jewel_count = 0
        jewel_set = set(jewels)
        for s in stones:
            if s in jewel_set:
                jewel_count += 1
        return jewel_count


if __name__ == "__main__":
    s = Solution()
    jewels = "aA"
    stones = "aAAbbbb"
    print(s.numJewelsInStones(jewels, stones))
    print(s.numJewelsInStones2(jewels, stones))
