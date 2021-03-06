fun main() {
    val s = Solution()
    var root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    root.left?.left = TreeNode(4)

    println(s.inorderTraversal_recursive(root))
    println(s.inorderTraversal_iterative(root))
}

class Solution {
    fun inorderTraversal_recursive(root: TreeNode?): List<Int> {
        // recursive solution
        if (root == null) {
            return emptyList<Int>()
        }

        val traversal = mutableListOf<Int>()
        traversal.addAll(inorderTraversal_recursive(root.left))
        traversal.add(root.`val`)
        traversal.addAll(inorderTraversal_recursive(root.right))
        return traversal
    }


    fun inorderTraversal_iterative(root: TreeNode?): List<Int> {
        // iterative, stack-based
        if (root == null) {
            return emptyList<Int>()
        }

        val traversal = mutableListOf<Int>()
        val stack = ArrayDeque<TreeNode?>()
        var cur = root
        while (true) {
            if (cur != null) {
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
                // add this value to list
                traversal.add(cur.`val`)
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