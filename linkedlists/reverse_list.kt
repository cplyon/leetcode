fun main() {
    val input = intArrayOf(1,2)
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

    printList(head)
    printList(reverseList_iterative(head))
    printList(reverseList_recursive(head))
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

fun reverseList_iterative(head: ListNode?): ListNode? {
    val stack = mutableListOf<ListNode>()
    var cur = head
    // put all nodes into a stack
    while (cur != null) {
        stack.add(0, cur)
        cur = cur.next
    }

    // set new head to previous tail
    var newHead : ListNode? = null
    if (stack.isNotEmpty()) {
        newHead = stack.removeAt(0)
        cur = newHead
    }
    
    // populate new list by popping off the stack
    while (stack.isNotEmpty()) {
        cur?.next = stack.removeAt(0)
        cur = cur?.next
    }

    // terminate list with null
    cur?.next = null

    return newHead
}

fun reverseList_recursive(head: ListNode?): ListNode? {
    // base case
    if (head == null || head.next == null) {
        return head
    }
    // recursive case
    var newHead = reverseList_recursive(head.next)
    head.next?.next = head
    head.next = null

    return newHead
}


class ListNode(var `val`: Int) {
    var next: ListNode? = null
}