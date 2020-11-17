fun main() {
    val s = Solution()
    var root: TreeNode? = TreeNode(1)
    root?.left = TreeNode(2)
    root?.right = TreeNode(3)
    root?.left?.left = TreeNode(4)
    root?.left?.right = TreeNode(5)
    root?.right?.left = TreeNode(6)
    root?.right?.right = TreeNode(7)
    root?.right?.left?.right = TreeNode(8)
    root?.right?.right?.right = TreeNode(9)

    println(s.zigzagLevelOrder(root))
}

class Solution {
    fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {

        if (root == null) {
            return emptyList<List<Int>>()
        }

        val paths = mutableListOf<MutableList<Int>>()

        // Breadth-first traversal
        // store the node and it's level (starting with root, 1)
        val queue = ArrayDeque<Pair<TreeNode?, Int>>()
        queue.addFirst(Pair<TreeNode?, Int>(root, 1))
        while (queue.isNotEmpty()) {

            val (curNode, level) = queue.removeLast()

            if (paths.size < level) {
                // first node at this level, so create a new list
                paths.add(mutableListOf<Int>())
            }

            // insert in zigzag order
            if (level % 2 == 1) {
                // append this element's value to the list
                paths[level-1].add(curNode!!.`val`)
            } else {
                // prepend this element's value to the list
                paths[level-1].add(0, curNode!!.`val`)
            }

            // add the non-null children
            curNode.left?.let {
                queue.addFirst(Pair<TreeNode?, Int>(it, level+1))
            }
            curNode.right?.let {
                queue.addFirst(Pair<TreeNode?, Int>(it, level+1))
            }
        }

        return paths
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}