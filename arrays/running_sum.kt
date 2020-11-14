fun main() {
    val nums = intArrayOf(1,2,3,4,5)
    runningSum(nums).forEach {
        print("$it ")
    }
}

fun runningSum(nums: IntArray): IntArray {
    var sumArray = nums.copyOf()
    for (i in 1..sumArray.size-1) {
        sumArray[i] += sumArray[i-1]
    }
    return sumArray
}