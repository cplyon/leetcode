#! /usr/bin/env python3

# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

    def __str__(self) -> str:
        return str(self.val) + " " + str(self.next)


class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        if not l1 and not l2:
            return None
        if not l1:
            return l2
        if not l2:
            return l1

        cur1 = l1
        cur2 = l2
        l3 = ListNode(-1)  # dummy node
        cur3 = l3
        carry = 0
        while cur1 is not None or cur2 is not None:
            val1 = cur1.val if cur1 else 0
            val2 = cur2.val if cur2 else 0
            sum = val1 + val2 + carry
            carry = sum // 10
            cur3.next = ListNode(sum % 10)

            cur1 = cur1.next if cur1 else None
            cur2 = cur2.next if cur2 else None
            cur3 = cur3.next

        if carry > 0:
            cur3.next = ListNode(carry)

        return l3.next


if __name__ == "__main__":
    s = Solution()
    l1 = ListNode(9)
    l1.next = ListNode(9)
    l1.next.next = ListNode(9)
    l1.next.next.next = ListNode(9)
    l1.next.next.next.next = ListNode(9)
    l1.next.next.next.next.next = ListNode(9)
    l1.next.next.next.next.next.next = ListNode(9)

    l2 = ListNode(9)
    l2.next = ListNode(9)
    l2.next.next = ListNode(9)
    l2.next.next.next = ListNode(9)

    print(s.addTwoNumbers(l1, l2))
