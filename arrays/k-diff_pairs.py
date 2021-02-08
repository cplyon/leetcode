#! /usr/bin/env python3

class Solution:
    def findPairs(self, nums: list[int], k: int) -> int:
        # O(n) time, O(n) space
        if not nums or len(nums) < 2 or k < 0:
            return 0
        result = 0
        counts = {}
        for n in nums:
            if n not in counts:
                counts[n] = 0
            counts[n] += 1

        for n in counts:
            if k == 0:
                if counts[n] > 1:
                    result += 1
            else:
                if n-k in counts:
                    result += 1
        return result


if __name__ == "__main__":
    s = Solution()
    nums = [3,1,4,1,5]
    k = 2
    nums = [1,2,3,4,5]
    k = 1
    nums = [1,3,1,5,4]
    k = 1
    print(s.findPairs(nums, k))
