fun main() {

    var root: TreeNode? = TreeNode(3)
    root?.left = TreeNode(9)
    root?.right = TreeNode(20)
    root?.right?.left = TreeNode(15)
    root?.right?.right = TreeNode(7)

    println(maxDepth(root))
}

fun maxDepth(root: TreeNode?): Int {
    if (root == null) {
        return 0
    }
    
    return Math.max(
            maxDepth(root.left), 
            maxDepth(root.right)) + 1
}


class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}