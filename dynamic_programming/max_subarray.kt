fun main() {
    val s = Solution()
    val nums = intArrayOf(-2,1,-3,4,-1,2,1,-5,4)
    println(s.maxSubArray(nums))
}

class Solution {
    fun maxSubArray(nums: IntArray): Int {

        if (nums.size == 0) {
            return 0
        }

        var maxSum = nums[0]
        var curSum = maxSum

        for (i in 1 until nums.size) {
            curSum = maxOf(nums[i], curSum + nums[i])
            maxSum = maxOf(curSum, maxSum)
        }

        return maxSum
    }
}