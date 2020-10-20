fun main() {

    var root: TreeNode? = TreeNode(24)
    root?.left = TreeNode(-60)
    root?.right = TreeNode(3)
    root?.left?.left = TreeNode(-60)
    println(isValidBST(root))
}

/*
    The left subtree of a node contains only nodes with keys less than the node's key.
    The right subtree of a node contains only nodes with keys greater than the node's key.
    Both the left and right subtrees must also be binary search trees.
 */


fun isValidBST(root: TreeNode?): Boolean {
    if (root?.left == null && root?.right == null) {
        return true
    }
    return isValidBST_helper(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY)
}

fun isValidBST_helper(root: TreeNode?, min: Double, max: Double): Boolean {
    if (root == null) return true

    return (root.`val` > min &&
        root.`val` < max &&
        isValidBST_helper(root.left, min, root.`val`.toDouble()) &&
        isValidBST_helper(root.right, root.`val`.toDouble(), max))
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}