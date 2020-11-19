fun main() {
    val s = Solution()
    var root: TreeNode? = TreeNode(3)
    root?.left = TreeNode(1)
    root?.right = TreeNode(4)
    root?.left?.right = TreeNode(2)

    val k = 1
    println(s.kthSmallest(root, k))
}

/*
    The number of elements of the BST is between 1 to 10^4.
    You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
*/
class Solution {

    var count = 0
    var result = -1

    fun kthSmallest(root: TreeNode?, k: Int): Int {
        // the kth smallest of a BST is the kth element in an inorder traversal
        inorderTraversal(root, k)
        return result
    }

    fun inorderTraversal(root: TreeNode?, k: Int) {
        if (root == null) {
            return
        }

        inorderTraversal(root.left, k)
        if (++count == k) {
            result = root.`val`
            return
        }
        inorderTraversal(root.right, k)

    }

}


class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}