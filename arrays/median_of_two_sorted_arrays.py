#! /usr/bin/env python3

class Solution:

    def findMedianSortedArrays(self, nums1: list[int], nums2: list[int]) -> float:
        # O(n+m), since we iterate both lists
        return self.findMedian(self.merge(nums1, nums2))

    def merge(self, nums1: list[int], nums2: list[int]) -> list[int]:
        if not nums1 and not nums2:
            return []
        if nums1 and not nums2:
            return nums1
        if nums2 and not nums1:
            return nums2

        i = 0
        j = 0
        merged = []
        while i < len(nums1) and j < len(nums2):
            if nums1[i] < nums2[j]:
                merged.append(nums1[i])
                i += 1
            else:
                merged.append(nums2[j])
                j += 1

        if i < len(nums1):
            return merged + nums1[i:]

        if j < len(nums2):
            return merged + nums2[j:]

        return merged

    def findMedian(self, nums: list[int]) -> float:
        mid = len(nums)//2
        if not nums:
            return 0.0
        if len(nums) % 2 != 0:
            return float(nums[mid])
        return (nums[mid] + nums[mid-1])/2


if __name__ == "__main__":
    s = Solution()
    nums1 = []
    nums2 = [4]
    print(s.findMedianSortedArrays(nums1, nums2))
