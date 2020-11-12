fun main() {
    val s = Solution()
    val nums = intArrayOf(1,1)
    //println(s.firstMissingPositive_sort(nums))
    //println(s.firstMissingPositive_set(nums))
    println(s.firstMissingPositive_linear(nums))
}


class Solution {
    fun firstMissingPositive_linear(nums: IntArray): Int {
        // O(n) time, O(1) space
        var i = 0

        // rearrange all values to match their indices (1-based)
        while (i < nums.size) {
            if (nums[i] > nums.size || nums[i] < 0) {
                // set all values outside the range of indices to 0
                nums[i] = 0
            }
            i++
        }

        i = 0
        while (i < nums.size) {
            // skip values that are outside the range of indices,
            // or are in the right spot already
            if (nums[i] > 0 && nums[i] != i+1) {
                val temp = nums[i]
                if (nums[temp-1] == nums[i]) {
                    // no sense swapping equal values, set this one to 0
                    // since the other one is in the right spot
                    nums[i] = 0
                } else {
                    // swap to put this one in the right place
                    nums[i] = nums[temp-1]
                    nums[temp-1] = temp
                    i--
                }
            }
            i++
        }

        i = 0
        while (i < nums.size) {
            if (nums[i] == 0) {
                // found the missing value!
                break
            }
            i++
        }

        // the missing value has already been found, or is larger than the
        // values in the list
        return i + 1
    }

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