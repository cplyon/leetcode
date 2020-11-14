fun main() {

    val input = intArrayOf(1,2,2,1)
    val head = populateList(input)

    println(hasCycle(head))
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

fun populateList(input: IntArray) : ListNode? {
    var head : ListNode? = null
    if (input.size > 0) {
        // populate list
        head = ListNode(input.first())
        var cur = head
        for (i in 1..input.size-1) {
            cur?.next = ListNode(input[i])
            cur = cur?.next
        }
    }
    return head
}

fun hasCycle(head: ListNode?): Boolean {
    if (head?.next == null) {
        return false
    }

    var slow = head
    var fast = head.next?.next

    while (fast != null) {
        if (slow == fast) {
            return true
        }
        fast = fast.next?.next
        slow = slow?.next
    }
    return false
}