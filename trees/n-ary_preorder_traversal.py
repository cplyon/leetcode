#! /usr/bin/env python3

# Definition for a binary tree node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children


class Solution:
    def preorder(self, root: Node) -> list[int]:
        # recursive
        if not root:
            return []

        result = []
        result.append(root.val)
        for child in root.children:
            result.extend(self.preorder(child))
        return result

    def preorder2(self, root: Node) -> list[int]:
        # iterative
        result = []
        if root:
            stack = [root]
            while len(stack) > 0:
                cur = stack.pop()
                result.append(cur.val)
                for child in cur.children[::-1]:
                    stack.append(child)
        return result


if __name__ == "__main__":
    s = Solution()
    root = Node(0, [])

    print(s.preorder(root))
    print(s.preorder2(root))
