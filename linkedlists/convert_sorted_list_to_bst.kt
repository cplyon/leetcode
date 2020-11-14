fun main() {
    val s = Solution()
    val head = ListNode(7)
    head.next = ListNode(9)
    head.next?.next = ListNode(14)
    s.sortedListToBST(head)
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun sortedListToBST(head: ListNode?): TreeNode? {

        if (head == null) {
            return null
        }
        if (head.next == null) {
            return TreeNode(head.`val`)
        }

        var count = 0
        var cur = head
        while (cur != null) {
            count++
            cur = cur.next
        }

        var midPoint = count / 2
        cur = head
        var prev: ListNode? = null
        for (i in 0 until midPoint) {
            prev = cur
            cur = cur?.next
        }

        prev?.next = null

        if (cur != null) {
            var root = TreeNode(cur.`val`)
            root.left = sortedListToBST(head)
            root.right = sortedListToBST(cur.next)
            return root
        }

        return null
    }
}