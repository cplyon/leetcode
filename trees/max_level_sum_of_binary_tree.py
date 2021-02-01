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
    def maxLevelSum(self, root: TreeNode) -> int:
        # BFS, saving each level's sum
        if not root:
            return root

        levels = []
        queue = [(root, 0)]
        while len(queue) != 0:
            cur, lvl = queue.pop(0)
            if not cur:
                continue
            if lvl == len(levels):
                levels.append(0)
            levels[lvl] += cur.val
            queue.append((cur.left, lvl+1))
            queue.append((cur.right, lvl+1))

        max_idx = 0
        max_sum = levels[max_idx]
        for i, n in enumerate(levels):
            if n > max_sum:
                max_sum = n
                max_idx = i
        return max_idx+1


if __name__ == "__main__":
    s = Solution()
    root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    root.left.left = TreeNode(4)
    root.left.right = TreeNode(5)
    root.left.left.left = TreeNode(7)
    root.right.right = TreeNode(6)
    root.right.right.right = TreeNode(-8)
    print(s.maxLevelSum(root))
