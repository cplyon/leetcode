fun main() {
    val nums = intArrayOf(2,2,1,3,9)
    println(thirdMax(nums))
}

fun thirdMax(nums: IntArray): Int {
    val unique = nums.toSet().toIntArray()
    var max1 = Int.MIN_VALUE
    var max2 = max1
    var max3 = max2

    for (n in unique) {
        var temp1 = max1
        var temp2 = max2
        if (n > max1) {
            max1 = n
            max2 = temp1
            max3 = temp2
        } else if (n > max2) {
            max2 = n
            max3 = temp2
        } else if (n > max3) {
            max3 = n
        }
    }

    if (unique.size < 3) {
        return max1
    }
    return max3
}