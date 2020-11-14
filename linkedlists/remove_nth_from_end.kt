fun main() {

    val input = intArrayOf(1,2,3,4)
    val n = 1

    // populate list
    val head = ListNode(input.first())
    var cur = head
    for (i in 1..input.size-1) {
        cur.next = ListNode(input[i])
        cur = cur.next!!
    }

    printList(head)
    printList(removeNthFromEnd(head, n))

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

fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {

    head?.let {
        if (head.next == null) {
            return null
        }

        var tail = head
        var cur : ListNode? = null
        var i = 1

        while (i < n) {
            tail = tail!!.next
            i++
        }
        while (tail != null && tail.next != null) {
            tail = tail.next
            if (cur == null) {
                cur = head
            } else {
                cur = cur.next
            }
        }

        // remove first element in list
        if (cur == null) {
            return head.next
        }

        // remove last element in list
        if (cur.next!!.next == null) {
            cur.next = null
            return head
        }
        
        // remove cur
        if (cur.next != null) {
            cur = cur.next
            cur!!.`val` = cur.next!!.`val`
            cur.next = cur.next!!.next
        }

        return head
    }

    return null

}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}