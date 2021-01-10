#! /usr/bin/env python3


class Solution:
    def search(self, nums: list[int], target: int) -> int:
        if nums:
            left = 0
            right = len(nums)-1
            while left <= right:
                mid = (left + right) // 2
                if nums[mid] == target:
                    return mid
                if nums[mid] > target:
                    right = mid - 1
                else:
                    left = mid + 1
        return -1

    def search_recursive(self, nums: list[int], target: int) -> int:
        if not nums:
            return -1

        mid = len(nums) // 2
        if nums[mid] == target:
            return mid

        if nums[mid] > target:
            return self.search(nums[:mid], target)

        result = self.search(nums[mid+1:], target)
        if result < 0:
            return result
        return result + mid + 1


if __name__ == "__main__":
    s = Solution()
    nums = [0, 1, 2, 3, 4, 8]
    target = 3
    print(s.search(nums, target))
    print(s.search_recursive(nums, target))
