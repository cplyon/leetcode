#! /usr/bin/env python3


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:

        if not root:
            return False

        return self.is_equal(root.left, root.right)

    def is_equal(self, left: TreeNode, right: TreeNode) -> bool:
        if not left and not right:
            return True

        if not left or not right:
            return False

        if left.val != right.val:
            return False

        return self.is_equal(left.left, right.right) and \
            self.is_equal(left.right, right.left)


if __name__ == "__main__":
    root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(2)
    root.left.left = TreeNode(3)
    root.left.right = TreeNode(4)
    root.right.left = TreeNode(4)
    root.right.right = TreeNode(3)
    s = Solution()
    print(s.isSymmetric(root))
