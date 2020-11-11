fun main() {
    val s = Solution()
    val nums = intArrayOf(1,0,3,-9,18,1,14,-1,4)
    println(s.firstMissingPositive_sort(nums))
    println(s.firstMissingPositive_set(nums))
}


class Solution {

    fun firstMissingPositive_set(nums: IntArray): Int {
        // O(n) time, O(n) space
        val seenNums = mutableSetOf<Int>()
        nums.forEach {
            seenNums.add(it)
        }

        for (i in 1..nums.size) {
            if (i !in seenNums) {
                return i
            }
        }
        return nums.size + 1
    }

    fun firstMissingPositive_sort(nums: IntArray): Int {
        // O(nlogn) time, O(1) space
        nums.sort()
        var smallestPos = 1
        var lastNum = -1
        nums.forEach {
            if (it > 0) {

                if (it != lastNum) {
                    if (it > smallestPos) {
                        return smallestPos
                    }
                    if (it == smallestPos) {
                        smallestPos += 1
                    } else if (it < smallestPos) {
                        smallestPos = it
                    }
                }
                lastNum = it
            }
        }

        return smallestPos
    }
}