#! /usr/bin/env python3

class Solution:
    def shuffle(self, nums: list[int], n: int) -> list[int]:
        if not nums or len(nums) <= 2:
            return nums

        shuffled = []
        for i in range(n):
            shuffled.append(nums[i])
            shuffled.append(nums[i+n])

        return shuffled


if __name__ == "__main__":
    s = Solution()
    nums = [1, 3, 5, 2, 4, 6]
    n = 3
    print(s.shuffle(nums, n))
