fun main() {
    val s = Solution()
    var root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    root.left?.left = TreeNode(4)

    println(s.postorderTraversal_recursive(root))
    println(s.postorderTraversal_iterative(root))
}

class Solution {
    fun postorderTraversal_recursive(root: TreeNode?): List<Int> {
        // recursive solution
        if (root == null) {
            return emptyList<Int>()
        }

        val traversal = mutableListOf<Int>()
        traversal.addAll(postorderTraversal_recursive(root.left))
        traversal.addAll(postorderTraversal_recursive(root.right))
        traversal.add(root.`val`)
        return traversal
    }

    fun postorderTraversal_iterative(root: TreeNode?): List<Int> {
        // iterative solution
        if (root == null) {
            return emptyList<Int>()
        }

        val traversal = mutableListOf<Int>()
        val stack = ArrayDeque<TreeNode?>()
        var cur = root
        var parent : TreeNode? = null
        while (cur!= null || stack.isNotEmpty()) {
            if (cur != null) {
                // iterate down the left side
                stack.addFirst(cur)
                cur = cur.left
            } else {
                // no more nodes to process on left

                // peek at the stack
                cur = stack.first()!!
                // if the last pushed is a leaf node or
                // the child of the last parent
                if (cur.right == null || cur.right == parent) {
                    // add this value to list
                    traversal.add(cur.`val`)
                    // set parent to node popped from the stack
                    parent = stack.removeFirst()
                    // no current node
                    cur = null
                } else {
                    // then move right
                    cur = cur.right
                }

            }

        }

        return traversal
    }

}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}