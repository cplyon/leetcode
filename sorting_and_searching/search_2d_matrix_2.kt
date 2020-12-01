fun main() {
    val s = Solution()

    val matrix = arrayOf<IntArray>(
        intArrayOf(1,4,7,11,15),
        intArrayOf(2,5,8,12,19),
        intArrayOf(3,6,9,16,22),
        intArrayOf(10,13,14,17,24),
        intArrayOf(18,21,23,26,30)
    )
    val target = 15
    println(s.searchMatrix(matrix, target))
}

class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        // O(mlogn)

        if (matrix.isEmpty()) {
            return false
        }
        // check the rightmost column for the first value >= target
        // binary search from that row until last
        for (row in matrix.indices) {
            if (matrix[row].last() >= target) {
                if (binarySearch(matrix[row], target)) {
                    return true
                }
            }
        }

        return false
    }

    fun binarySearch(array: IntArray, target: Int) : Boolean {
        var left = 0
        var right = array.size-1
        while (left <= right) {
            val mid = (left+right)/2
            if (target == array[mid]) {
                return true
            }
            if (target > array[mid]) {
                left = mid+1
            } else {
                right = mid-1
            }
        }
        return false
    }

}