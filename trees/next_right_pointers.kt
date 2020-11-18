fun main() {

    val s = Solution()
    var root = Node(1)
    root.left = Node(2)
    root.right = Node(3)

    val newNode = s.connect(root)

    println(newNode)
    println(newNode?.left)
    println(newNode?.right)
}


class Solution {

    fun connect(root: Node?): Node? {
        // O(1) space, O(n) time
        if (root == null) {
            return null
        }

        var head = root
        while (head != null && head.left != null) {
            var cur = head
            while (cur != null) {
                cur.left?.next = cur.right
                if (cur.next != null) {
                    cur.right?.next = cur.next?.left
                }
                cur = cur.next
            }
            head = head.left
        }

        return root
    }



    fun connect2(root: Node?): Node? {
        // O(n) space, O(n) time
        if (root == null) {
            return null
        }

        val levels = mutableListOf<MutableList<Node>>()
        val queue = ArrayDeque<Pair<Node, Int>>()
        queue.addFirst(Pair<Node, Int>(root, 1))
        while (queue.isNotEmpty()) {

            val (cur, level) = queue.removeLast()
            if (levels.size < level) {
                levels.add(mutableListOf<Node>())
            }
            levels[level-1].add(cur)

            cur.left?.let {
                queue.addFirst(Pair<Node, Int>(cur.left!!, level+1))
            }
            cur.right?.let {
                queue.addFirst(Pair<Node, Int>(cur.right!!, level+1))
            }
        }

        // set the next pointers at each level
        for (level in levels) {
            for (i in 0 until level.size-1) {
                level[i].next = level[i+1]
            }
        }

        return root
    }
}


class Node(var `val`: Int) {
    var left: Node? = null
    var right: Node? = null
    var next: Node? = null

    override fun toString() : String {
        return "${`val`} $next"
    }
 }