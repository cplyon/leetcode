fun main() {
    val s = Solution()
    var root = TreeNode(4)
    root.left = TreeNode(2)
    root.right = TreeNode(7)
    root.left?.left = TreeNode(1)
    root.left?.right = TreeNode(3)
    println(s.searchBST_recursive(root, 3))
    println(s.searchBST_iterative(root, 3))
}

class Solution {
    fun searchBST_recursive(root: TreeNode?, `val`: Int): TreeNode? {
        if (root == null || root.`val` == `val`) return root
        return if (`val` < root.`val`) {
            searchBST_recursive(root.left, `val`)
        } else {
            searchBST_recursive(root.right, `val`)
        }
    }


    fun searchBST_iterative(root: TreeNode?, `val`: Int): TreeNode? {
        var cur = root
        while (cur != null && cur.`val` != `val`) {
            cur = if (`val` < cur.`val`) {
                cur.left
            } else {
                cur.right
            }
        }
        return cur
    }

}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null

    override fun toString() : String {
        return "$`val`, $left, $right"
    }
}