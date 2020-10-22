fun main() {

    var root: TreeNode? = TreeNode(1)
    root?.left = TreeNode(2)
    root?.right = TreeNode(3)
    root?.left?.left = TreeNode(4)
    root?.right?.right = TreeNode(5)
    root?.left?.left?.left = TreeNode(6)
    root?.right?.right?.right = TreeNode(7)
    root?.right?.right?.right?.right = TreeNode(8)
    
    printList(levelOrder(root))
    
}

fun levelOrder(root: TreeNode?): List<List<Int>> {
    val retVal = mutableListOf<MutableList<Int>>()

    root?.let {
        val levelNodes = mutableListOf<Pair<Int, TreeNode>>()
        levelNodes.add(0, Pair<Int,TreeNode>(0, root))
        retVal.add(mutableListOf(root.`val`))
        
        while (levelNodes.isNotEmpty()) {
            val (nodeHeight, node) = levelNodes.removeAt(levelNodes.lastIndex)
            val levelVals = mutableListOf<Int>()
            
            node.left?.let {
                levelNodes.add(0, Pair<Int, TreeNode>(nodeHeight+1, node.left!!))
                levelVals.add(node.left!!.`val`)
            } 

            node.right?.let {
                levelNodes.add(0, Pair<Int, TreeNode>(nodeHeight+1, node.right!!))
                levelVals.add(node.right!!.`val`)
            }            
            
            if (levelVals.isNotEmpty()) {
                if (nodeHeight+1 == retVal.size) {
                    retVal.add(levelVals)
                } else {
                    retVal[nodeHeight+1].addAll(levelVals)
                }                 
            }
            
        }
    }

    return retVal
}

fun printList(list: List<List<Int>>) = list.forEach { l ->
    print("[")
    l.forEach {
        print("$it ")
    }
    print("]")
}


class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null

    override fun toString() : String {
        return `val`.toString()
    }
}