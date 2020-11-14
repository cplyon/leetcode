fun main() {
    val nums = intArrayOf(4,3,2,7,8,2,3,1)
    println(findDisappearedNumbers(nums))
}

fun findDisappearedNumbers(nums: IntArray): List<Int> {
    var unique = nums.toSet()
    var retList = mutableListOf<Int>()
    for (i in 1..nums.size) {
        if (i !in unique) {
            retList.add(i)
        }
    }

    return retList
}