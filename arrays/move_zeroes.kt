fun main() {
    val nums = intArrayOf(1,0, 0, 2)
    moveZeroes(nums)
    nums.forEach {
        print("$it ")
    }
    println()
}

fun moveZeroes(nums: IntArray) {
    var zeroCount = 0
    var index = -1

    for (i in nums.indices) {
        if (nums[i] == 0) {
            zeroCount++
        } else {
            index++
            nums[index] = nums[i]
        }
    }

    for (i in 1..zeroCount) {
        nums[nums.size - i] = 0
    }

}