fun main() {
    val s = Solution()
    val nums = intArrayOf(1,2,13,14,3,2)
    println(s.findPeakElement_linear(nums))
    println(s.findPeakElement(nums))
}

class Solution {

    fun findPeakElement(nums: IntArray): Int {
        // O(logn) time
        if (nums.isEmpty()) {
            return -1
        }

        if (nums.size == 1) {
            return 0
        }

        if (nums[0] > nums[1]) {
            return 0
        }
        if (nums[nums.size-1] > nums[nums.size-2]) {
            return nums.size-1
        }

        // binary search
        var left = 0
        var right = nums.size - 1
        while (left <= right) {
            val mid = (left + right) / 2
            val max = maxOf(nums[mid], nums[mid-1], nums[mid+1])
            if (max == nums[mid]) {
                return mid
            }
            if (max == nums[mid-1]) {
                right = mid
            } else {
                left = mid
            }
        }

        return -1

    }




    fun findPeakElement_linear(nums: IntArray): Int {
        // O(n) time

        // base case: empty array
        if (nums.isEmpty()) {
            return -1
        }

        // base case: single element
        if (nums.size == 1) {
            return 0
        }

        // base case: first element is the peak
        if (nums[0] > nums[1]) {
            return 0
        }

        // base case: last element is the peak
        if (nums[nums.size-1] > nums[nums.size-2]) {
            return nums.size-1
        }

        // iterate the array looking for a higher element
        var i = 1
        while (nums[i] < nums[i+1]) {
            i++
        }

        return i
    }

}