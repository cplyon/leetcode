#! /usr/bin/env python3

# Definition for a binary tree node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children


class Solution:
    def maxDepth(self, root: Node) -> int:
        if not root:
            return 0

        depth = 0
        for child in root.children:
            depth = max(self.maxDepth(child), depth)

        return depth + 1



if __name__ == "__main__":
    s = Solution()
    root = Node(0, [])

    print(s.maxDepth(root))
