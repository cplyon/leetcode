import java.util.PriorityQueue

fun main() {
    val s = Solution()
    val nums = intArrayOf(3,2,3,1,2,4,5,5,6)
    val k = 4
    println(s.findKthLargest(nums, k))
    println(s.findKthLargest2(nums, k))
}

class Solution {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        // O(nlogn)
        if (nums.isEmpty()) {
            throw IllegalArgumentException()
        }

        if (nums.size == 1) {
            return nums[0]
        }

        val elements = nums.toMutableList()
        elements.sortDescending()
        return elements[k-1]
    }

    fun findKthLargest2(nums: IntArray, k: Int): Int {
        // O(nlogn)
        if (nums.isEmpty()) {
            throw IllegalArgumentException()
        }

        if (nums.size == 1) {
            return nums[0]
        }

        val pq = PriorityQueue<Int>()
        for (n in nums) {
            pq.add(n)
        }

        val result = mutableListOf<Int>()
        for (n in nums) {
            result.add(pq.poll())
        }

        println(result)

        return result[result.size - k]
    }
}