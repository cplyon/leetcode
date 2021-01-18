#! /usr/bin/env python3

class Solution:
    def findDuplicate(self, nums: list[int]) -> int:
        # O(n) time, O(n) space
        if not nums:
            return -1

        uniques = set()
        for n in nums:
            if n in uniques:
                return n
            uniques.add(n)

        return -1


    def findDuplicate2(self, nums: list[int]) -> int:
        # O(nlogn) time, O(1) space
        if not nums:
            return -1

        nums.sort()
        m = nums[0]
        for n in nums[1:]:
            if n == m:
                return n
            m = n

        return -1


if __name__ == "__main__":
    s = Solution()
    nums = [1,2,3,3,4]
    print(s.findDuplicate(nums))
    print(s.findDuplicate2(nums))
