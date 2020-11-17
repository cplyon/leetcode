fun main() {
    val s = Solution()
    var root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    root.left?.left = TreeNode(4)

    println(s.preorderTraversal_recursive(root))
    println(s.preorderTraversal_iterative(root))
}

class Solution {
    fun preorderTraversal_recursive(root: TreeNode?): List<Int> {
        // recursive solution
        if (root == null) {
            return emptyList<Int>()
        }

        val traversal = mutableListOf<Int>()
        traversal.add(root.`val`)
        traversal.addAll(preorderTraversal_recursive(root.left))
        traversal.addAll(preorderTraversal_recursive(root.right))
        return traversal
    }

    fun preorderTraversal_iterative(root: TreeNode?): List<Int> {
        // iterative solution
        if (root == null) {
            return emptyList<Int>()
        }

        val traversal = mutableListOf<Int>()
        val stack = ArrayDeque<TreeNode?>()
        var cur = root

        while (true) {
            if (cur != null) {
                // add this value to the list
                traversal.add(cur.`val`)
                // iterate down the left side
                stack.addFirst(cur)
                cur = cur.left
            } else {
                // no more nodes to process on left

                if (stack.isEmpty()) {
                    // we're done!
                    break
                }

                // pop the next node
                cur = stack.removeFirst()!!
                // then move right
                cur = cur.right
            }
        }

        return traversal
    }

}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}