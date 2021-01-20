#! /usr/bin/env python3

class Solution:
    def intersect(self, nums1: list[int], nums2: list[int]) -> list[int]:
        if not nums1 or not nums2:
            return []

        result = []
        counts1 = self.count(nums1)
        counts2 = self.count(nums2)
        for c in counts1:
            if c in counts2:
                result.extend([c] * min(counts1[c], counts2[c]))

        return result

    def count(self, nums: list[int]) -> dict[str, int]:
        counts = {}
        for n in nums:
            if n not in counts:
                counts[n] = 0
            counts[n] += 1
        return counts


if __name__ == "__main__":
    s = Solution()
    nums1 = [1, 1, 2, 4]
    nums2 = [3, 1, 4, 4]
    print(s.intersect(nums1, nums2))
