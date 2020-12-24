#! /usr/local/bin/python3
# Given an array of integers nums and an integer target,
# return indices of the two numbers such that they add up to target.
# You may assume that each input would have exactly one solution,
# and you may not use the same element twice.
# You can return the answer in any order.

class Solution:
    def twoSum(self, nums: list[int], target: int) -> list[int]:
        if len(nums) == 0:
            return []

        sums = {}

        for (i, n) in enumerate(nums):
            diff = target - n
            if diff in sums:
                return [sums[diff], i]
            sums[n] = i


if __name__ == "__main__":
    s = Solution()
    nums = [2, 3, 1, -15, 11]
    target = 4
    print(s.twoSum(nums, target))
