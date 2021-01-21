#! /usr/bin/env python3

# Definition for a binary tree node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children


class Solution:
    def postorder(self, root: Node) -> list[int]:
        if not root:
            return []

        result = []
        for child in root.children:
            result.extend(self.postorder(child))
        result.append(root.val)
        return result


    def postorder2(self, root: Node) -> list[int]:
        # iterative
        result = []
        if root:
            stack = [root]
            while len(stack) > 0:
                cur = stack.pop()
                for child in cur.children:
                    stack.append(child)
                result.insert(0, cur.val)
        return result



if __name__ == "__main__":
    s = Solution()
    root = Node(0, [])

    print(s.postorder(root))
    print(s.postorder2(root))
