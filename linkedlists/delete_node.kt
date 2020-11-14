fun main() {

    // input values
    val input = intArrayOf(-3,5,99)
    val deletedValue = 5

    // populate list
    val head = ListNode(input.first())
    var cur = head
    var deletedNode : ListNode? = null
    for (i in 1..input.size-1) {
        if (cur.`val`==deletedValue) {
            deletedNode = cur
        }
        var value = input[i]
        cur.next = ListNode(value)
        cur = cur.next!!
    }

    // run program and print results
    printList(head)
    deleteNode(deletedNode)
    printList(head)

}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}


// given access to a node, delete it from the list
// no access to head
// node is guaranteed to not be the tail
fun deleteNode(node: ListNode?) {
    node?.let {
        var cur = node
        cur.next?.let {
            cur.`val` = cur.next!!.`val`
            cur.next = cur.next!!.next
        }
    }
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