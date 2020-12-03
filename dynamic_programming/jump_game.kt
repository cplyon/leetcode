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

        // base case
        var prev = nums[0]

        // recurrence relation
        // f(i) = max(f(i-1)-1, nums[i])
        for (i in 1 until nums.size) {
            if (prev == 0) {
                return false
            }
            var cur = maxOf(prev-1, nums[i])
            if (cur <= 0) {
                return false
            }
            if (i + cur >= nums.size-1) {
                return true
            }
            prev = cur
        }
        return false
    }
}