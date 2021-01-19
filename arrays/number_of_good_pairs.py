#! /usr/bin/env python3

class Solution:
    def numIdenticalPairs(self, nums: list[int]) -> int:
        if not nums:
            return 0

        counts = {}
        for i in range(len(nums)):
            if nums[i] not in counts:
                counts[nums[i]] = 0
            counts[nums[i]] += 1

        pair_count = 0
        for n in counts.keys():
            m = counts[n]
            pair_count += (m*(m-1))//2

        return pair_count


if __name__ == "__main__":
    s = Solution()
    nums = [1,1,1,1]
    print(s.numIdenticalPairs(nums))
