fun main() {

    var root: TreeNode? = TreeNode(3)
    root?.left = TreeNode(9)
    root?.right = TreeNode(20)
    root?.left?.left = TreeNode(19)
    root?.right?.left = TreeNode(15)
    root?.right?.right = TreeNode(7)

    val s = Solution()
    println(s.minDepth(root))
}

class Solution {
    fun minDepth(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }

        if (root.left == null && root.right == null) {
            return 1
        }

        if (root.left == null) {
            return minDepth(root.right) + 1
        }

        if (root.right == null) {
            return minDepth(root.left) + 1
        }

        return minOf(minDepth(root.left), minDepth(root.right)) + 1
    }
}


class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}