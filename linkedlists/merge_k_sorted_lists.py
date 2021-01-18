#! /usr/bin/env python3

# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

    def __str__(self) -> str:
        return str(self.val) + "->" + str(self.next)


class Solution:
    def mergeKLists(self, lists: list[ListNode]) -> ListNode:
        # O(n*m) since we're comparing each value against all others
        # array-based, not linked-list-based
        if not lists:
            return None

        min_value = 2**31-1
        sorted_list = ListNode(min_value)
        cur = sorted_list
        min_index = 0
        list_indexes = [0] * len(lists)
        continue_count = 0
        while continue_count < len(lists):
            min_value = sorted_list.val
            continue_count = 0
            for i in range(len(lists)):
                j = list_indexes[i]
                if j >= len(lists[i]):
                    continue_count += 1
                    continue
                val = lists[i][j]
                if val <= min_value:
                    min_value = val
                    min_index = i

            if min_value == sorted_list.val:
                break
            list_indexes[min_index] += 1
            cur.next = ListNode(min_value)
            cur = cur.next

        return sorted_list.next

    def mergeKLists2(self, lists: list[ListNode]) -> ListNode:
        # O(n*m) since we're comparing each value against all others
        if not lists:
            return None

        min_value = 2**31-1
        sorted_list = ListNode(min_value)
        cur_sorted = sorted_list
        continue_count = 0
        while continue_count < len(lists):
            min_value = sorted_list.val
            continue_count = 0
            cur = None
            min_index = 0
            for i in range(len(lists)):
                cur = lists[i]
                if cur is None:
                    continue_count += 1
                    continue
                if cur.val <= min_value:
                    min_value = cur.val
                    min_index = i
            if min_value == sorted_list.val:
                break
            lists[min_index] = lists[min_index].next
            cur_sorted.next = ListNode(min_value)
            cur_sorted = cur_sorted.next

        return sorted_list.next

    def mergeKLists3(self, lists: list[ListNode]) -> ListNode:
        # O(nlgn) time, since we sort
        if not lists:
            return None

        sorted_list = ListNode(0)  # Dummy node
        cur_sorted = sorted_list
        values = []

        for root in lists:
            cur = root
            while cur:
                values.append(cur.val)
                cur = cur.next

        for v in sorted(values):
            cur_sorted.next = ListNode(v)
            cur_sorted = cur_sorted.next

        return sorted_list.next



if __name__ == "__main__":
    s = Solution()
    lists = [[1,4,5],[1,3,4],[2,6]]
    print(s.mergeKLists(lists))

    lists = []
    lists.append(ListNode(1))
    lists[-1].next = ListNode(4)
    lists[-1].next.next = ListNode(5)
    lists.append(ListNode(1))
    lists[-1].next = ListNode(3)
    lists[-1].next.next = ListNode(4)
    lists.append(ListNode(2))
    lists[-1].next = ListNode(6)

    print(s.mergeKLists2(lists))

    lists = []
    lists.append(ListNode(1))
    lists[-1].next = ListNode(4)
    lists[-1].next.next = ListNode(5)
    lists.append(ListNode(1))
    lists[-1].next = ListNode(3)
    lists[-1].next.next = ListNode(4)
    lists.append(ListNode(2))
    lists[-1].next = ListNode(6)
    print(s.mergeKLists3(lists))
