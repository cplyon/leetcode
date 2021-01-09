#! /usr/bin/env python3

class Solution:
    def missingNumber(self, nums: list[int]) -> int:
        # find missing number by subtracting the sum of nums
        # from the expected sum
        return sum([i for i in range(len(nums)+1)]) - sum(nums)

    def missingNumber2(self, nums: list[int]) -> int:
        # find missing number by subtracting the sum of nums
        # from the mathematically-derived expected sum
        # (n*(n+1))/2 = sum(0..n)
        n = len(nums)
        return (n*(n+1))//2 - sum(nums)


if __name__ == "__main__":
    s = Solution()
    nums = [0, 1, 2, 3, 4, 6]
    print(s.missingNumber(nums))
    print(s.missingNumber2(nums))
