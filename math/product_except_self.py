#! /usr/bin/env python3

class Solution:
    def productExceptSelf(self, nums: list[int]) -> list[int]:
        if len(nums) <= 1:
            return 0

        L = [1] * len(nums)
        for i in range(1, len(nums)):
            L[i] = L[i-1]*nums[i-1]
        R = [1] * len(nums)
        for i in range(len(nums)-2, -1, -1):
            R[i] = R[i+1]*nums[i+1]

        return [L[i]*R[i] for i in range(len(nums))]


if __name__ == "__main__":
    s = Solution()
    nums = [1, 2, 3, 4, 5]
    print(s.productExceptSelf(nums))
