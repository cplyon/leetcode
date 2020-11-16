fun main() {
    val s = Solution()
    var head = ListNode(1)
    head.next = ListNode(2)
  //  head.next?.next = ListNode(3)
  //  head.next?.next?.next = ListNode(4)
  //  head.next?.next?.next?.next = ListNode(5)
  //  head.next?.next?.next?.next?.next = ListNode(6)
    printList(s.oddEvenList(head))
}

class Solution {

    fun oddEvenList(head: ListNode?): ListNode? {
        if (head == null || head.next == null) {
            return head
        }

        var oddTail = head
        var evenHead = head.next
        var evenTail = head.next
        head.next = evenHead?.next
        var cur = evenHead?.next // odd
        while (cur != null) {
            // since cur is odd, point the even list at cur's next
            // then move the even tail to the next even
            evenTail?.next = cur.next
            evenTail = evenTail?.next

            // move the odd tail to the next odd
            oddTail = oddTail?.next

            // skip the next even number, and move cur
            // two nodes
            cur.next = cur.next?.next
            cur = cur.next
        }

        // attach the evens after the odd tail
        oddTail?.next = evenHead
        // terminate the list
        evenTail?.next = null

        return head
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