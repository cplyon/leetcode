fun main() {
    val nums = intArrayOf(3, 3)
    val target = 6
    twoSum(nums, target).forEach { print("$it ") }
    println()
}


fun twoSum(nums: IntArray, target: Int): IntArray {
    val diffTable = HashMap<Int, Int>()
    val retList = mutableListOf<Int>()
    nums.forEach {
        diffTable.put(it, target-it)
    }

    var halfIndex = -1
    for (i in nums.indices) {
        if (nums[i] == target-nums[i]) {
            if (halfIndex >= 0) {
                retList.add(halfIndex)
                retList.add(i)
            } else {
                halfIndex = i
            }
        } else if (diffTable.contains(target-nums[i])) {
            retList.add(i)
        }
    }
    
    return retList.toIntArray()
}