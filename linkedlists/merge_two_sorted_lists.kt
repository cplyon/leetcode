fun main() {

    val input1 = intArrayOf(2,3,6)
    val head1 = populateList(input1)
    val input2 = intArrayOf(1,2,3)
    val head2 = populateList(input2)
    printList(mergeTwoLists(head1, head2))
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

fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
    var cur1 = l1
    var cur2 = l2
    var output: ListNode? = null
    var cur = output

    while (cur1 != null && cur2 != null) {
        if (cur1.`val` < cur2.`val`) {
            if (output == null) {
                output = cur1
                cur = output
            } else { 
                cur?.next = cur1
                cur = cur?.next
            }
            cur1 = cur1.next
        } else {
            if (output == null) {
                output = cur2
                cur = output
            } else { 
                cur?.next = cur2
                cur = cur?.next
            }
            cur2 = cur2.next
        }
    }

    while (cur1 != null) {
        if (output == null) {
            output = cur1
            cur = output
        } else {
            cur?.next = cur1
            cur = cur?.next 
        }    
        cur1 = cur1.next        
    }

    while (cur2 != null) {
        if (output == null) {
            output = cur2
            cur = output
        } else {
            cur?.next = cur2
            cur = cur?.next                    
        }
        cur2 = cur2.next
    }    

    return output
}