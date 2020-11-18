fun main() {
    val s = Solution()

    val preorder = intArrayOf(1,2,4,5,3,6,7)
    val inorder = intArrayOf(4,2,5,1,6,3,7)
    val root = s.buildTree(preorder, inorder)
    println(root)
    println(root?.left)
    println(root?.right)
}

class Solution {
    //  You may assume that duplicates do not exist in the tree.
    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        // recursive solution that divides up the input arrays and creates subtrees

        // pre and in must have the same elements
        if (preorder.toSet() != inorder.toSet()) {
            throw IllegalArgumentException()
        }

        // base case: empty lists
        if (preorder.size == 0) {
            return null
        }

        // first element in preorder is the root of the tree
        val rootNode = TreeNode(preorder.first())

        if (preorder.size > 1) {
            // find the root in inorder
            val rootIndexIn = inorder.indexOf(rootNode.`val`)

            // divide the lists into subtree elements

            // elements with index < rootIndexIn are in the left subtree
            // elements with index > rootIndexIn are in the right subtree
            val leftSubIn = inorder.sliceArray(0..rootIndexIn-1)
            val rightSubIn = inorder.sliceArray(rootIndexIn+1..inorder.size-1)

            // elements with index > 1 && < leftSubIn.size are in the left subtree
            // elements with index > letfSubIn.size are in the right subtree
            val leftSubPre = preorder.sliceArray(1..leftSubIn.size)
            val rightSubPre = preorder.sliceArray(leftSubIn.size+1..preorder.size-1)

            // recurse for each subtree
            rootNode.left = buildTree(leftSubPre, leftSubIn)
            rootNode.right = buildTree(rightSubPre, rightSubIn)
        }

        return rootNode
    }
}


class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null

    override fun toString() : String {
        return `val`.toString()
    }
}