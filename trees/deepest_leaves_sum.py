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

    def deepestLeavesSum2(self, root: TreeNode) -> int:
        # DFS, saving the sum of the max depth seen so far
        if not root:
            return root

        max_lvl = 0
        max_sum = 0
        stack = [(root, 0)]
        while len(stack) != 0:
            cur, lvl = stack.pop(0)
            if not cur:
                continue
            if lvl == max_lvl:
                max_sum += cur.val
            elif lvl > max_lvl:
                max_lvl = lvl
                max_sum = cur.val
            stack.insert(0, (cur.left, lvl+1))
            stack.insert(0, (cur.right, lvl+1))

        return max_sum


    def deepestLeavesSum(self, root: TreeNode) -> int:
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

        return levels[-1]



if __name__ == "__main__":
    s = Solution()
    root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    root.left.left = TreeNode(4)
    root.left.right = TreeNode(5)
    root.left.left.left = TreeNode(7)
    root.right.right = TreeNode(6)
    root.right.right.right = TreeNode(8)
    print(s.deepestLeavesSum(root))
    print(s.deepestLeavesSum2(root))
