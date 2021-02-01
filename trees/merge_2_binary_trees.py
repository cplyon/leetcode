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
    def mergeTrees(self, t1: TreeNode, t2: TreeNode) -> TreeNode:
        if not t1:
            return t2
        if not t2:
            return t1

        t3 = TreeNode(t1.val + t2.val)
        t3.left = self.mergeTrees(t1.left, t2.left)
        t3.right = self.mergeTrees(t1.right, t2.right)
        return t3


if __name__ == "__main__":
    s = Solution()
    t1 = TreeNode(1)
    t1.left = TreeNode(3)
    t1.right = TreeNode(5)
    t2 = TreeNode(2)
    t2.left = TreeNode(4)
    print(s.mergeTrees(t1, t2))
