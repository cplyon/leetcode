#! /usr/bin/env python3

class Solution:
    def __init__(self):
        self.uniques = set()

    def permuteUnique(self, nums: list[int]) -> list[list[int]]:
        if len(nums) == 0:
            return nums
        if len(nums) == 1:
            return [nums]

        result = []
        for perm in self.permuteUnique(nums[1:]):
            for i in range(len(perm)+1):
                p = perm[:i] + [nums[0]] + perm[i:]
                s = str(p)
                if s not in self.uniques:
                    result.append(p)
                    self.uniques.add(s)
        return result


if __name__ == "__main__":
    s = Solution()
    nums = [1, 17, 8]
    print(s.permuteUnique(nums))