#! /usr/bin/env python3

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

    def __str__(self) -> str:
        return str(self.val)


# Given the root of a binary tree, return its maximum depth.
# A binary tree's maximum depth is the number of nodes along the longest path
# from the root node down to the farthest leaf node.
class Solution:

    def maxDepth_iterative(self, root: TreeNode) -> int:
        # iterative DFS
        max_depth = 0
        if root:
            stack = []
            stack.insert(0, (root, 0))
            while len(stack) > 0:
                cur, depth = stack.pop(0)
                depth += 1
                if cur.left:
                    stack.insert(0, (cur.left, depth))
                if cur.right:
                    stack.insert(0, (cur.right, depth))
                max_depth = max(max_depth, depth)

        return max_depth

    def maxDepth_recursive(self, root: TreeNode) -> int:
        # recursive DFS
        if not root:
            return 0

        return max(self.maxDepth_recursive(root.left),
                   self.maxDepth_recursive(root.right)) + 1


if __name__ == "__main__":
    s = Solution()
    root = TreeNode(3)
    root.left = TreeNode(9)
    root.right = TreeNode(20)
    root.right.left = TreeNode(15)
    root.right.right = TreeNode(7)
    print(s.maxDepth_iterative(root))
    print(s.maxDepth_recursive(root))
