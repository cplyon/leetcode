#! /usr/bin/env python3

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

    def __str__(self) -> str:
        return str(self.val)


# Given the root node of a binary search tree (BST) and a value.
# You need to find the node in the BST that the node's value equals the given
# value. Return the subtree rooted with that node.
# If such node doesn't exist, you should return NULL.
class Solution:
    def searchBST(self, root: TreeNode, val: int) -> TreeNode:
        if root:
            cur = root
            while cur:
                if val > cur.val:
                    cur = cur.right
                elif val < cur.val:
                    cur = cur.left
                else:
                    return cur

        return None

    def searchBST_recursive(self, root: TreeNode, val: int) -> TreeNode:
        if root:
            if val < root.val:
                return self.searchBST_recursive(root.left, val)
            if val > root.val:
                return self.searchBST_recursive(root.right, val)

        return root


if __name__ == "__main__":
    s = Solution()
    root = TreeNode(4)
    root.left = TreeNode(2)
    root.right = TreeNode(7)
    root.left.left = TreeNode(1)
    root.left.right = TreeNode(3)
    print(s.searchBST(root, 3))
    print(s.searchBST_recursive(root, 3))
