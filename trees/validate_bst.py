#! /usr/bin/env python3

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

    def __str__(self) -> str:
        return str(self.val)


# Given the root of a binary tree, determine if it is a valid binary search tree (BST).
# A valid BST is defined as follows:
#    The left subtree of a node contains only nodes with keys less than the node's key.
#    The right subtree of a node contains only nodes with keys greater than the node's key.
#    Both the left and right subtrees must also be binary search trees.

class Solution:

    def isValidBST(self, root: TreeNode) -> bool:
        if not root:
            return True

        # call a helper with min/max set to extremes
        return self.helper(root, -2**32, 2**32)

    def helper(self, root: TreeNode, min_val: int, max_val: int) -> bool:
        if not root:
            return True

        # return True if the curren node's value is between min_val and max_val
        # and recurse checking the left subtree is between min_val and the root's value
        # and checking the right subtree is between max_val and the root's value
        return root.val > min_val and root.val < max_val and \
            self.helper(root.left, min_val, root.val) and \
            self.helper(root.right, root.val, max_val)


if __name__ == "__main__":
    s = Solution()
    root = TreeNode(5)
    root.left = TreeNode(1)
    root.right = TreeNode(10)
    root.right.left = TreeNode(9)
    root.right.right = TreeNode(11)
    root.right.left.left = TreeNode(4)
    print(s.isValidBST(root))
