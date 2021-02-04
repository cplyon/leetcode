#! /usr/bin/env python3

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

    def __str__(self):
        return str(self.val) + " " + str(self.left) + " " + str(self.right)


class Solution:
    def bstFromPreorder(self, preorder: list[int]) -> TreeNode:
        if not preorder:
            return None
        root = TreeNode(preorder[0])

        left = None
        right = None
        for i, n in enumerate(preorder[1:]):
            if left is None and n < preorder[0]:
                left = i+1
            if right is None and n > preorder[0]:
                right = i+1

        if left is not None:
            root.left = self.bstFromPreorder(preorder[left:right])
        if right is not None:
            root.right = self.bstFromPreorder(preorder[right:])

        return root


if __name__ == "__main__":
    s = Solution()
    preorder = [8, 5, 1, 7, 10, 12]
    print(s.bstFromPreorder(preorder))
