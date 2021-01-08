#! /usr/bin/env python3

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

    def __str__(self) -> str:
        return str(self.val)


# Given two binary trees original and cloned and given a reference to a node
# target in the original tree.
# The cloned tree is a copy of the original tree.
# Return a reference to the same node in the cloned tree.
# Note that you are not allowed to change any of the two trees or the target
# node and the answer must be a reference to a node in the cloned tree.
# Follow up: Solve the problem if repeated values on the tree are allowed.
class Solution:
    def getTargetCopy(self, original: TreeNode, cloned: TreeNode,
                      target: TreeNode) -> TreeNode:
        # O(n+n) => O(n)
        # DFS inorder traversal, saving path to target in original
        # replay path in cloned

        if not original or not cloned or not target:
            return None
        path = self.generate_path(original, target)
        return self.replay_path(cloned, path)

    def replay_path(self, root: TreeNode, path: list[int]) -> TreeNode:
        if not root or not path:
            return None
        cur = root
        for n in path:
            if n == 1:
                cur = cur.right
            elif n == -1:
                cur = cur.left
            else:
                return cur
        # not found
        return None

    def generate_path(self, root: TreeNode, target: TreeNode) -> list[int]:
        path = []
        if root and target:
            if root == target:
                path.append(0)
                return path

            left_path = self.generate_path(root.left, target)
            if left_path:
                path.append(-1)
                path.extend(left_path)

            right_path = self.generate_path(root.right, target)
            if right_path:
                path.append(1)
                path.extend(right_path)

        return path


if __name__ == "__main__":

    original = TreeNode(5)
    original.left = TreeNode(1)
    original.right = TreeNode(10)
    original.right.left = TreeNode(9)
    original.right.right = TreeNode(11)
    original.right.left.left = TreeNode(4)

    cloned = TreeNode(5)
    cloned.left = TreeNode(1)
    cloned.right = TreeNode(10)
    cloned.right.left = TreeNode(9)
    original.right.right = TreeNode(11)
    cloned.right.left.left = TreeNode(4)

    target = original.right.left.left

    s = Solution()
    print(s.getTargetCopy(original, cloned, target))
