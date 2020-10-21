fun main() {

    var root: TreeNode? = TreeNode(1)
    root?.left = TreeNode(2)
    root?.right = TreeNode(2)
    root?.left?.left = TreeNode(3)
    root?.left?.right = TreeNode(4)
    root?.right?.left = TreeNode(4)
    root?.right?.right = TreeNode(3)
<<<<<<< HEAD


=======
>>>>>>> 3a5d019... Is Binary Tree Symmetric
    println(isSymmetric(root))
}

fun isSymmetric(root: TreeNode?): Boolean {
    if (root == null) {
        return true
    }

    return areEqual(root.left, root.right)
}

fun areEqual(left: TreeNode?, right: TreeNode?) : Boolean {
    // both nodes are null
    if (left == null && right == null) {
        return true
    }

    // only one node is null
    if (left == null || right == null) {
        return false
    }

    // values are not equal
    if (left.`val` != right.`val`) {
        return false
    }

    // recurse down a level
    return areEqual(left.left, right.right) && areEqual(left.right, right.left)
}


class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}