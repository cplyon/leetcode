fun main() {
    val s = Solution()

    var tail = ListNode(10)
    tail.next = ListNode(11)
    tail.next?.next = ListNode(12)

    var headA = ListNode(1)
    headA.next =  ListNode(3)
    headA.next?.next = tail

    var headB = ListNode(2)
    headB.next = ListNode(4)
    headB.next?.next = tail

    printList(s.getIntersectionNode(headA, headB))
    printList(s.getIntersectionNode(headA, null))
    printList(s.getIntersectionNode(null, headB))
    printList(s.getIntersectionNode(null, null))
    printList(s.getIntersectionNode(tail, tail))
    printList(s.getIntersectionNode(headA, tail))
}

class Solution {

    fun getIntersectionNode(headA:ListNode?, headB:ListNode?):ListNode? {
        // find list lengths and start longest one first
        // O(1) space, O(n) time
        if (headA == null || headB == null) {
            return null
        }

        if (headA == headB) {
            return headA
        }

        var countA = 0
        var countB = 0
        var curA = headA
        while (curA!=null) {
            curA = curA?.next
            countA++
        }
        var curB = headB
        while (curB!=null) {
            curB = curB?.next
            countB++
        }

        curA = headA
        curB = headB
        if (countA > countB) {
            for (i in 0 until (countA-countB)) {
                curA = curA?.next
            }
        } else if (countB > countA) {
            for (i in 0 until (countB-countA)) {
                curB = curB?.next
            }
        }

        while (curA != null && curB != null) {
            if (curA == curB) {
                return curA
            }
            curA = curA?.next
            curB = curB?.next
        }

        return null
    }

    fun getIntersectionNode_stack(headA:ListNode?, headB:ListNode?):ListNode? {
        // dual stack-based solution
        // O(n) space, O(n) time

        if (headA == null || headB == null) {
            return null
        }

        if (headA == headB) {
            return headA
        }

        val stackA = ArrayDeque<ListNode>()
        val stackB = ArrayDeque<ListNode>()

        var curA = headA
        while (curA != null) {
            stackA.addFirst(curA)
            curA = curA.next
        }
        var curB = headB
        while (curB != null) {
            stackB.addFirst(curB)
            curB = curB.next
        }

        var common : ListNode? = null
        while (curA == curB) {
            if (stackA.isNotEmpty()) {
                curA = stackA.removeFirst()
            }

            if (stackB.isNotEmpty()) {
                curB = stackB.removeFirst()
            }

            if (curA == curB) {
                common = curA
            }
        }

        return common
    }

}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}


fun printList(node: ListNode?) {
    node?.let {
        var cur = node
        while (cur != null) {
            print("${cur.`val`} ")
            cur = cur.next
        }
    }
    println()
}