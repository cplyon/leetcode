fun main() {
    val nums = intArrayOf(3, 3)
    val target = 6
    twoSum(nums, target).forEach { print("$it ") }
    println()
}


fun twoSum(nums: IntArray, target: Int): IntArray {
    val diffTable = HashMap<Int, Int>()

    for ((i, n) in nums.withIndex()) {
        val diff = target-n
        if (diffTable.contains(diff)) {
            return intArrayOf(i, diffTable.get(diff)!!)
        }
        diffTable.put(n, i)
    }

    return intArrayOf()
}