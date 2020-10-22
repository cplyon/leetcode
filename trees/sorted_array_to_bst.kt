fun main() {
    var nums = intArrayOf(-10,-3,0,5,9)
    println(sortedArrayToBST(nums))
}

fun sortedArrayToBST(nums: IntArray): TreeNode? {
    if (nums.size == 0) {
        return null
    }
    if (nums.size == 1) {
        return TreeNode(nums[0])
    }

    var midPoint = nums.size / 2
    var root = TreeNode(nums[midPoint])
    root.left = sortedArrayToBST(nums.sliceArray(0 until midPoint))
    root.right = sortedArrayToBST(nums.sliceArray(midPoint + 1 until nums.size))

    return root
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null

    override fun toString() : String {
        return `val`.toString()
    }
}