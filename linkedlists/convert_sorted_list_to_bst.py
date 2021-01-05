#! /usr/bin/env python3


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

    def __str__(self) -> str:
        return "{} {} {}".format(self.val, self.left, self.right)


# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def sortedListToBST(self, head: ListNode) -> TreeNode:
        if not head:
            return None

        nums = []
        cur = head
        while cur:
            nums.append(cur.val)
            cur = cur.next

        return self.sortedArrayToBST(nums)

    def sortedArrayToBST(self, nums: list[int]) -> TreeNode:
        if not nums:
            return None

        mid = len(nums) // 2
        root = TreeNode(nums[mid])
        root.left = self.sortedArrayToBST(nums[:mid])
        root.right = self.sortedArrayToBST(nums[mid+1:])
        return root


if __name__ == "__main__":
    s = Solution()
    head = ListNode(7)
    head.next = ListNode(9)
    head.next.next = ListNode(14)
    print(s.sortedListToBST(head))
