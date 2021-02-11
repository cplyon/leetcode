#! /usr/bin/env python3

# Given an array of integers numbers that is already sorted in ascending order,
# find two numbers such that they add up to a specific target number.

# Return the indices of the two numbers (1-indexed) as an integer array answer
# of size 2, where 1 <= answer[0] < answer[1] <= numbers.length.

# You may assume that each input would have exactly one solution and you may
# not use the same element twice.


class Solution:
    def twoSum(self, numbers: list[int], target: int) -> list[int]:
        if numbers:
            left = 0
            right = len(numbers)-1
            while left < right:
                sum = numbers[left] + numbers[right]
                if sum > target:
                    right -= 1
                elif sum < target:
                    left += 1
                else:
                    return [left+1, right+1]

        return []


if __name__ == "__main__":
    s = Solution()
    numbers = [2,7,11,15]
    target = 9
    print(s.twoSum(numbers, target))
