fun main() {
    val s = Solution()
    val l1 = ListNode(1)
    l1.next = ListNode(1)
    l1.next?.next = ListNode(1)
    l1.next?.next?.next = ListNode(1)
    val l2 = ListNode(9)
    l2.next = ListNode(9)
    l2.next?.next = ListNode(9)

    printList(s.addTwoNumbers(l1, l2))
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


class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {

        var sumList : ListNode? = null
        var cur1 = l1
        var cur2 = l2
        var cur3 = sumList
        var carry = 0
        while (cur1 != null || cur2 != null) {
            var curSum = (cur1?.`val` ?: 0) + (cur2?.`val` ?: 0) + carry
            carry = curSum / 10
            val newNode = ListNode(curSum % 10)
            if (sumList == null) {
                sumList = newNode
                cur3 = sumList
            } else {
                newNode.next = cur3!!.next
                cur3.next = newNode
                cur3 = cur3.next
            }
            cur1 = cur1?.next
            cur2 = cur2?.next
        }

        if (carry > 0) {
            val newNode = ListNode(1)
            newNode.next = cur3!!.next
            cur3.next = newNode
        }

        return sumList

    }
}