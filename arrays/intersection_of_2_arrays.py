#! /usr/bin/env python3

class Solution:
    def intersection(self, nums1: list[int], nums2: list[int]) -> list[int]:
        return list(set(nums1).intersection(set(nums2)))

    def intersection2(self, nums1: list[int], nums2: list[int]) -> list[int]:
        result = []
        set1 = set(nums1)
        for n in nums2:
            if n in set1:
                result.append(n)
                set1.remove(n)

        return result


if __name__ == "__main__":
    s = Solution()
    nums1 = [1, 2, 2, 4]
    nums2 = [2, 5, 8]
    print(s.intersection(nums1, nums2))
    print(s.intersection2(nums1, nums2))
