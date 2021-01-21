#! /usr/bin/env python3

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def levelOrder(self, root: TreeNode) -> list[list[int]]:
        result = []
        queue = []

        queue.append((root, 0))
        while len(queue) > 0:
            cur, level = queue.pop(0)
            if not cur:
                continue
            if len(result) == level:
                # new level
                result.append([])
            result[level].append(cur.val)
            queue.append((cur.left, level+1))
            queue.append((cur.right, level+1))

        return result


if __name__ == "__main__":
    s = Solution()
    root = TreeNode(0)
    root.left = TreeNode(1)
    root.right = TreeNode(11)
    root.left.left = TreeNode(2)
    root.left.right = TreeNode(22)
    root.right.right = TreeNode(2222)
    print(s.levelOrder(root))
