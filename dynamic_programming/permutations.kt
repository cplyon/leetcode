fun main() {
    val s = Solution()
    val nums = intArrayOf(1,2, 3)
    println(s.permute(nums))
}


class Solution {
    fun permute(nums: IntArray): List<List<Int>> {

        if (nums.size == 0) {
            return emptyList()
        }

        if (nums.size == 1) {
            return listOf<List<Int>>(listOf(nums[0]))
        }

        val permutations = mutableListOf<List<Int>>()
        for (perm in permute(nums.sliceArray(1 until nums.size))) {
            for (i in 0..perm.size) {
                permutations.add(
                    perm.toMutableList().apply {
                        this.add(i, nums[0])
                    }
                )
            }
        }

        return permutations
    }
}