#! /usr/bin/env python3

class Solution:
    def smallerNumbersThanCurrent(self, nums: list[int]) -> list[int]:
        # O(nlgn) + O(n) + O(n) = O(nlgn)
        result = []

        if len(list) > 1:
            indices = {}
            for i, n in enumerate(sorted(nums)):
                if n not in indices:
                    indices[n] = i

            for n in nums:
                result.append(indices[n])

        return result


if __name__ == "__main__":
    s = Solution()
    nums = [1, 2, 3, 4, 5, 6]
    print(s.smallerNumbersThanCurrent(nums))
