fun main() {
    val s = Solution()
    val nums = intArrayOf(1,2,3,4)
    println(s.subsets(nums))
    println(s.subsets_iterative(nums))
}

class Solution {
    fun subsets(nums: IntArray): List<List<Int>> {

        val result = mutableListOf(mutableListOf<Int>())
        result.addAll(generate_subset(nums))

        return result
    }

    fun generate_subset(nums:IntArray) : MutableList<MutableList<Int>> {
        // recursive solution

        // base case 1: empty input
        if (nums.size == 0) {
            return mutableListOf(mutableListOf())
        }

        // base case 2: single element
        if (nums.size == 1) {
            return mutableListOf(mutableListOf(nums[0]))
        }

        val result = mutableListOf(mutableListOf<Int>(nums[0]))
        val subsets = generate_subset(nums.sliceArray(1 until nums.size))
        for (s in subsets) {
            result.add(s)
            val newValue = s.toMutableList()
            newValue.add(nums[0])
            result.add(newValue)
        }

        return result
    }


    fun subsets_iterative(nums: IntArray): List<List<Int>> {
        // iterative solution
        val result = mutableListOf(mutableListOf<Int>())
        for (n in nums) {
            for (i in result.indices) {
                val newValues = result[i].toMutableList()
                newValues.add(n)
                result.add(newValues)
            }
        }
        return result
    }
}