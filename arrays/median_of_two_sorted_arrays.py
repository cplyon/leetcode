#! /usr/bin/env python3

class Solution:

    def findMedianSortedArrays(self, nums1: list[int], nums2: list[int]) -> float:
        # O(n+m), since we iterate both lists
        if not nums1 and not nums2:
            return 0.0
        if nums1 and not nums2:
            return self.findMedian(nums1)
        if nums2 and not nums1:
            return self.findMedian(nums2)

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
        if not nums:
            return 0.0
        if len(nums) % 2 != 0:
            return float(nums[len(nums)//2])
        return (nums[len(nums)//2] + nums[len(nums)//2-1])/2


if __name__ == "__main__":
    s = Solution()
    nums1 = [1, 3]
    nums2 = [2, 4]
    print(s.findMedianSortedArrays(nums1, nums2))
