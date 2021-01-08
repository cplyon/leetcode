#! /usr/bin/env python3

class Solution:
    def kidsWithCandies(self, candies: list[int], extraCandies: int) -> list[bool]:
        max_candies = max(candies)
        return [candies[i] + extraCandies >= max_candies for i in range(len(candies))]


if __name__ == "__main__":
    s = Solution()
    candies = [12, 1, 12]
    extraCandies = 10
    print(s.kidsWithCandies(candies, extraCandies))
