#! /usr/bin/env python3

# Definition for a binary tree node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children


class Solution:
    def levelOrder(self, root: Node) -> list[list[int]]:
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
            for child in cur.children:
                queue.append((child, level+1))

        return result


if __name__ == "__main__":
    s = Solution()
    root = Node(0, [])

    print(s.levelOrder(root))
