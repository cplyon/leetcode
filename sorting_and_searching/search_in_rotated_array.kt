fun main() {
    val s = Solution()
    val target = 0
    println(s.search(intArrayOf(4,5), target))
}

class Solution {
    fun search(nums: IntArray, target: Int): Int {
        // use two binary searches:
        // first one to find the max element
        // second to search the portion of nums target lives in
        if (nums.isEmpty()) {
            return -1
        }

        if (nums.size == 1) {
            if (nums[0] == target) {
                return 0
            }
            return -1
        }

        val highestIndex = binarySearchHighest(nums)
        if (target == nums[highestIndex]) {
            return highestIndex
        }

        var left = 0
        var right = nums.size-1
        if (highestIndex == 0) {
            left = 1
            right = nums.size-1
        } else if (highestIndex == nums.size-1) {
            left = 0
            right = highestIndex-1
        } else if (target >= nums[0]) {
            // target lives before highest
            left = 0
            right = highestIndex-1
        } else if (target >= nums[highestIndex+1]) {
            // target lives after highest
            left = highestIndex+1
            right = nums.size-1
        }

        return binarySearch(nums, target, left, right)
    }

    fun binarySearch(nums: IntArray, target: Int, left: Int, right: Int) : Int {
        var l = left
        var r = right
        while (l <= r) {
            val mid = (l+r) / 2
            if (nums[mid] == target) {
                return mid
            }
            if (nums[mid] > target) {
                r = mid - 1
            } else {
                l = mid + 1
            }
        }
        return -1
    }

    fun binarySearchHighest(nums: IntArray) : Int {
        var left = 0
        var right = nums.size - 1
        var mid = (left+right) / 2
        var highest = mid

        while (left < right) {
            var next = highest + 1
            var prev = highest - 1
            if (highest == 0) {
                prev = nums.size - 1
            } else if (highest == nums.size-1) {
                next = 0
            }

            if (nums[highest] > nums[prev] && nums[highest] > nums[next]) {
                return highest
            } else if (nums[prev] > nums[highest]) {
                highest = prev
            } else if (nums[next] > nums[highest]) {
                highest = next
            }

            var leftMid = (left+mid-1) / 2
            var rightMid = (mid+1+right) / 2
            if (nums[leftMid] > nums[highest]) {
                right = leftMid - 1
                highest = leftMid
            } else if (nums[rightMid] > nums[highest]) {
                left = rightMid + 1
                highest = rightMid
            }
        }

        return highest
    }
}