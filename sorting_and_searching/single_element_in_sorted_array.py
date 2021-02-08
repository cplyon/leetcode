#! /usr/bin/env python3

# You are given a sorted array consisting of only integers where every element
# appears exactly twice, except for one element which appears exactly once.
# Find this single element that appears only once.
# Follow up: Your solution should run in O(log n) time and O(1) space.

class Solution:

    def singleNonDuplicate1(self, nums: list[int]) -> int:
        # O(n) time, O(1) space
        if not nums:
            return -1
        uniques = set()
        for n in nums:
            if n not in uniques:
                uniques.add(n)
            else:
                uniques.remove(n)
        return uniques.pop()

    def singleNonDuplicate2(self, nums: list[int]) -> int:
        # O(n) time, O(1) space
        if not nums:
            return -1
        if len(nums) == 1:
            return nums[0]

        if nums[0] != nums[1]:
            return nums[0]
        for i in range(1, len(nums)-1):
            if nums[i] != nums[i-1] and nums[i] != nums[i+1]:
                return nums[i]
        return nums[-1]

    def singleNonDuplicate(self, nums: list[int]) -> int:
        # O(logn) time, O(1) space
        if not nums:
            return -1

        left = 0
        right = len(nums)-1
        mid = 0
        while left <= right:
            mid = (left + right) // 2
            if mid > 0 and nums[mid-1] == nums[mid]:
                if (mid-1 - left) % 2 == 1:
                    right = mid - 2
                else:
                    left = mid + 1
            elif mid < len(nums)-1 and nums[mid+1] == nums[mid]:
                if (right - mid+1) % 2 == 1:
                    left = mid + 2
                else:
                    right = mid - 1
            else:
                return nums[mid]
        return nums[mid]


if __name__ == "__main__":
    s = Solution()
    nums = [1,1,2,3,3,4,4,8,8]
    nums = [1,2,2,3,3,4,4,5,5]
    nums = [1]
    print(s.singleNonDuplicate(nums))
