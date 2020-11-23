fun main() {
    val s = Solution()
    val nums = intArrayOf(2,0)
    s.printArray(nums)
    println()
    s.sortColors(nums)
    s.printArray(nums)
}

class Solution {
    fun sortColors(nums: IntArray): Unit {

        var head = 0
        var tail = nums.lastIndex
        if (tail <= head) {
            // empty list or single element
            return
        }

        var cur = head
        while (cur <= tail) {
            if (nums[cur] == 2) {
                if (nums[tail] != 2) {
                    swap(nums, cur, tail)
                }
                tail--
            } else if (nums[cur] == 0) {
                if (cur > head && nums[head] != 0) {
                    swap(nums, cur, head)
                }
                head++
                cur = maxOf(cur, head)
            } else {
                cur++
            }
        }
    }

    fun swap(nums: IntArray, i: Int, j: Int) {
        val temp = nums[i]
        nums[i] = nums[j]
        nums[j] = temp
    }

    fun printArray(array: IntArray) = array.forEach {
        print("$it ")
    }
}