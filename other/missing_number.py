#! /usr/bin/env python3

class Solution:
    def missingNumber(self, nums: list[int]) -> int:
        # find missing number by subtracting the sum of nums
        # from the expected sum
        # O(n+n) => O(n)
        return sum([i for i in range(len(nums)+1)]) - sum(nums)

    def missingNumber2(self, nums: list[int]) -> int:
        # find missing number by subtracting the sum of nums
        # from the mathematically-derived expected sum
        # (n*(n+1))/2 = sum(0..n)
        # O(n)
        n = len(nums)
        return (n*(n+1))//2 - sum(nums)

    def missingNumber3(self, nums: list[int]) -> int:
        # find missing number by subtracting each values in nums
        # from each value from 0 to n
        # O(n)
        missing_number = 0
        for i in range(len(nums)):
            missing_number += i - nums[i]
        return missing_number + len(nums)


if __name__ == "__main__":
    s = Solution()
    nums = [0, 1, 2, 3, 4, 6]
    print(s.missingNumber(nums))
    print(s.missingNumber2(nums))
    print(s.missingNumber3(nums))
