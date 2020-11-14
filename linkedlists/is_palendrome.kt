fun main() {

    val input1 = intArrayOf(1,2,2,1)
    val head1 = populateList(input1)

    println(isPalindrome(head1))
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

fun isPalindrome(head: ListNode?): Boolean {
    if (head == null || head.next == null) {
        return true
    }

    var front = head
    fun recurse(back: ListNode?) : Boolean {
        var retVal = true
        if (back?.next != null) {
            retVal = retVal && recurse(back.next)
        }

        if (front?.`val` == back?.`val`) {
            front = front?.next
            return retVal
        }
        return false
    }     

    return recurse(head.next)   
}