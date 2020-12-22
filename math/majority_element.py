#! /usr/local/bin/python3

from typing import DefaultDict


class Solution:
    def majorityElement(self, nums: list[int]) -> int:
        counts = DefaultDict(int)
        for n in nums:
            counts[n] = counts[n]+1
            if counts[n] > len(nums)//2:
                return n
        return 0

    def majorityElement_sorted(self, nums: list[int]) -> int:
        return sorted(nums)[len(nums)//2]


if __name__ == "__main__":
    s = Solution()
    nums = [2,2,1,1,1,2,2]
    print(s.majorityElement(nums))
    print(s.majorityElement_sorted(nums))
