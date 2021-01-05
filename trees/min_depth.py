#! /usr/bin/env python3


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def minDepth(self, root: TreeNode) -> int:
        # DFS
        if not root:
            return 0

        if not root.left and not root.right:
            return 1

        if not root.left:
            return self.minDepth(root.right) + 1

        if not root.right:
            return self.minDepth(root.left) + 1

        return min(self.minDepth(root.left), self.minDepth(root.right)) + 1

    def minDepth_bfs(self, root: TreeNode) -> int:
        # BFS
        if not root:
            return 0

        queue = []
        queue.append((root, 0))
        while len(queue) > 0:
            cur, depth = queue.pop(0)
            depth += 1
            if not cur.left and not cur.right:
                return depth
            if cur.left:
                queue.append((cur.left, depth))
            if cur.right:
                queue.append((cur.right, depth))

        return 0


if __name__ == "__main__":
    root = TreeNode(1)
    root.left = TreeNode(2)
    #root.right = TreeNode(2)
    root.left.left = TreeNode(3)
    #root.left.right = TreeNode(4)
    #root.right.left = TreeNode(4)
    #root.right.right = TreeNode(3)
    s = Solution()
    print(s.minDepth(root))
    print(s.minDepth_bfs(root))
