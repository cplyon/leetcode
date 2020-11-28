fun main() {
    val s = Solution()
    val nums = intArrayOf(0,0,0,1,1,2,2,2,2,3,3,4,4,4,4,5,64)
    val target = 4
    println(s.searchRange(nums, target).toList())
    println(s.searchRange_linear(nums, target).toList())
}

class Solution {

    fun searchRange(nums: IntArray, target: Int): IntArray {
        // three binary searches (find an index of target, binary search the subarrays on either side)
        // O(logn)

        val range = intArrayOf(-1,-1)
        if (nums.isEmpty()) {
            return range
        }

        val firstFound = binarySearch(nums, 0, nums.size-1, target)
        if (firstFound < 0) {
            return range
        }
        range[0] = firstFound
        range[1] = firstFound

        var leftResult = firstFound
        while (leftResult >= 0) {
            leftResult = binarySearch(nums, 0, leftResult-1, target)
            if (leftResult >= 0) {
                range[0] = leftResult
            }
        }
        var rightResult = firstFound
        while (rightResult >= 0) {
            rightResult = binarySearch(nums, rightResult+1, nums.size, target)
            if (rightResult >= 0) {
                range[1] = rightResult
            }
        }
        return range
    }

    fun binarySearch(nums: IntArray, leftMost: Int, rightMost: Int, target: Int): Int {
        var left = leftMost
        var right = rightMost
        while (left <= right) {
            var mid = (left+right)/2
            if (mid >= nums.size) {
                return -1
            }
            if (nums[mid] > target) {
                right = mid - 1
            } else if (nums[mid] < target) {
                left = mid + 1
            } else {
                return mid
            }
        }
        return -1
    }

    fun searchRange_linear(nums: IntArray, target: Int): IntArray {
        // binary search, then linear expansion
        // worst case, O(n)

        val range = intArrayOf(-1,-1)
        if (nums.isEmpty()) {
            return range
        }

        var left = 0
        var right = nums.size - 1
        while (left <= right) {
            var mid = (left+right)/2
            if (nums[mid] > target) {
                right = mid - 1
            } else if (nums[mid] < target) {
                left = mid + 1
            } else {
                var leftRange = mid
                while (leftRange >= 0 && nums[leftRange] == target) {
                    range[0] = leftRange
                    leftRange--
                }
                var rightRange = mid
                while (rightRange < nums.size && nums[rightRange] == target) {
                    range[1] = rightRange
                    rightRange++
                }
                return range
            }
        }

        return range
    }
}