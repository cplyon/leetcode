#! /usr/bin/env python3

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

    def __str__(self) -> str:
        return str(self.val) + " " + str(self.left) + " " + str(self.right)


class Solution:
    def constructMaximumBinaryTree(self, nums: list[int]) -> TreeNode:
        if not nums:
            return None

        max_val = max(nums)
        max_idx = nums.index(max_val)
        return TreeNode(max_val,
                        self.constructMaximumBinaryTree(nums[:max_idx]),
                        self.constructMaximumBinaryTree(nums[max_idx+1:]))


if __name__ == "__main__":
    s = Solution()
    nums = [3, 2, 1, 6, 0, 5]
    print(s.constructMaximumBinaryTree(nums))
