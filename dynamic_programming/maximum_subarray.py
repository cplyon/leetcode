#! /usr/bin/env python3

class Solution:
    def maxSubArray(self, nums: list[int]) -> int:
        if not nums:
            return 0

        curSum = nums[0]
        maxSum = curSum
        for n in nums[1:]:
            curSum = max(n, curSum + n)
            maxSum = max(maxSum, curSum)
        return maxSum


if __name__ == "__main__":
    s = Solution()
    nums = [-2,1,-3,4,-1,2,1,-5,4]
    print(s.maxSubArray(nums))
