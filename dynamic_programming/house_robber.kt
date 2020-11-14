fun main() {
    val s = Solution()
    val nums = intArrayOf(1,3,1,9,4,17,2)
    println(s.rob(nums))
    println(s.rob_recursive(nums))

}

class Solution {

    fun rob(nums: IntArray): Int {

        // base case 1: empty list
        if (nums.size == 0) {
            return 0
        }

        // base case 2: single item
        if (nums.size == 1) {
            return nums[0]
        }

        // base case 3: 2-item list
        if (nums.size == 2) {
            return Math.max(nums[0], nums[1])
        }

        // memoization: populate indices 0-3
        val sums = IntArray(nums.size)
        sums[0] = nums[0]
        sums[1] = Math.max(nums[1], sums[0])
        sums[2] = Math.max(nums[2] + sums[0], sums[1])
        var maxSum = Math.max(sums[1], sums[2])

        // recurrence relation: f(i) = nums[i] + max(f(i-2), f(i-3))
        for (i in 3 until nums.size) {
            sums[i] = nums[i] + Math.max(sums[i-2], sums[i-3])
            maxSum = Math.max(maxSum, sums[i])
        }

        return maxSum
    }

    fun rob_recursive(nums: IntArray): Int {

        // base case 1: empty list
        if (nums.size == 0) {
            return 0
        }

        // base case 2: single item
        if (nums.size == 1) {
            return nums[0]
        }

        // base case 3: 2-item list
        if (nums.size == 2) {
            return Math.max(nums[0], nums[1])
        }

        // recurrence relation: f(i) = nums[i] + max(f(i-2), f(i-3))
        var maxSum = Math.max(nums[0], nums[1])
        for (i in 2 until nums.size) {
            val curSum = nums[i] + Math.max(rob_recursive(nums.sliceArray(0 until i-1)),
                                            rob_recursive(nums.sliceArray(0 until i-2)))
            maxSum = Math.max(maxSum, curSum)
        }
        return maxSum
    }

}