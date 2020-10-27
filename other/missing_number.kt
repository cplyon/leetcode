fun main() {
    var nums = intArrayOf(0,1,2,3,4,5,6,8,9,10)
    println(missingNumber(nums))
}


fun missingNumber(nums: IntArray): Int {
    var expectedSum = 0
    for (i in 0..nums.size) { 
        expectedSum += i
    }
    var actualSum = 0
    nums.forEach {
        actualSum += it
    }
    return expectedSum - actualSum
}