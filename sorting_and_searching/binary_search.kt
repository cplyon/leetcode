fun main() {
    val s = Solution()
    val nums = intArrayOf(-1,0,3,5,9,12)
    val target = 13
    println(s.search_iterative(nums, target))
    println(s.search_recursive(nums, target))

}

class Solution {
    fun search_iterative(nums: IntArray, target: Int): Int {
        // iterative solution
        if (nums.isEmpty()) {
            return -1
        }

        var left = 0
        var right = nums.lastIndex
        while (left <= right) {
            var mid = (left + right) / 2
            if (nums[mid] == target) {
                return mid
            }
            if (nums[mid] > target) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }

        return -1
    }

    fun search_recursive(nums: IntArray, target: Int): Int {
        // recursive solution
        if (nums.isEmpty()) {
            return -1
        }

        var mid = nums.size / 2

        return if (nums[mid] == target) {
            mid
        } else if (nums.size == 1) {
            -1
        } else if (nums[mid] > target) {
            search_recursive(nums.sliceArray(0 until mid), target)
        } else {
            val result = search_recursive(nums.sliceArray(mid until nums.size), target)
            if (result < 0) {
                result
            } else {
                mid + result
            }
        }
    }

}