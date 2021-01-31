#! /usr/bin/env python3

# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

    def __str__(self):
        return str(self.val) + " " + str(self.next)


class Solution:
    def sortList(self, head: ListNode) -> ListNode:
        # O(nlgn) time
        # O(n) space
        if not head or not head.next:
            return head

        array = []
        cur = head
        while cur:
            array.append(cur)
            cur = cur.next
        array.sort(key=lambda x: x.val)
        for i in range(len(array)-1):
            array[i].next = array[i+1]
        array[-1].next = None
        return array[0]


if __name__ == "__main__":
    s = Solution()
    head = ListNode(5)
    head.next = ListNode(4)
    head.next.next = ListNode(3)
    head.next.next.next = ListNode(2)
    head.next.next.next.next = ListNode(1)
    head.next.next.next.next.next = ListNode(0)
    print(s.sortList(head))
