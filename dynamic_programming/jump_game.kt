fun main() {
    val s = Solution()
    val nums = intArrayOf(0,1)
    println(s.canJump(nums))
}

class Solution {
    fun canJump(nums: IntArray): Boolean {

        if (nums.isEmpty()) {
            return false
        }

        if (nums.size == 1) {
            return true
        }

        // objective function:
        // f(i) = max step reachable from step i
        val dp = IntArray(nums.size) {0}

        // base case
        dp[0] = nums[0] // we can always reach the 0th step
        if (dp[0] == 0) {
            return false
        }

        // recurrence relation
        // f(i) = max(f(i-1)-1, nums[i])
        for (i in 1..dp.size-1) {
            dp[i] = maxOf(dp[i-1]-1, nums[i])
            if (dp[i] <= 0) {
                return false
            }
            if (i + dp[i] >= nums.size-1) {
                return true
            }
        }
        return false
    }
}