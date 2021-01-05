#! /usr/bin/env python3


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

    def __str__(self) -> str:
        return "{} {} {}".format(self.val, self.left, self.right)


class Solution:
    def sortedArrayToBST(self, nums: list[int]) -> TreeNode:
        if not nums:
            return None

        mid = len(nums) // 2
        root = TreeNode(nums[mid])
        root.left = self.sortedArrayToBST(nums[:mid])
        root.right = self.sortedArrayToBST(nums[mid+1:])
        return root

if __name__ == "__main__":
    s = Solution()
    nums = [0,1,2,3,4,5,6,7,8]
    print(s.sortedArrayToBST(nums))
