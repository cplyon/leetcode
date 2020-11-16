fun main() {

    val s = Solution()
    var nums = intArrayOf(5,6,2,1,4,3,0)  //F
    println(s.increasingTriplet(nums))
    nums = intArrayOf(1,2,3,4,5)  //T
    println(s.increasingTriplet(nums))
    nums = intArrayOf(5,4,3,2,1)  //F
    println(s.increasingTriplet(nums))
    nums = intArrayOf(5,0,8,7)  //F
    println(s.increasingTriplet(nums))
    nums = intArrayOf(100,0,0,101,98,99)  //T
    println(s.increasingTriplet(nums))
    nums = intArrayOf(2,1,5,0,4,6)  //T
    println(s.increasingTriplet(nums))
    nums = intArrayOf(2,5,3,4,5)  //T
    println(s.increasingTriplet(nums))
    nums = intArrayOf(1,0,-1,1,2)  //T
    println(s.increasingTriplet(nums))
    nums = intArrayOf(2,2,3)  //F
    println(s.increasingTriplet(nums))
    nums = intArrayOf(1,0,2,0,-1,3)  //T
    println(s.increasingTriplet(nums))
}

class Solution {
    fun increasingTriplet(nums: IntArray): Boolean {

        // bail early on invalid input
        if (nums.size < 3) {
            return false
        }

        var length = 1
        var max = nums[0]
        var min = nums[0]
        for (i in 1 until nums.size) {

            when {
                nums[i] > max -> {
                    // make nums[i] the new max
                    // increment length unless min and max are equal
                    if (++length == 3) {
                        // we found our triplet!
                        return true
                    }
                    max = nums[i]
                }
                nums[i] == max -> {
                    // the triplet doesn't change,
                    // but only set the length if min and max aren't the same
                    if (min != max) {
                        length=2
                    }
                }
                nums[i] < max && nums[i] > min -> {
                    // within the triplet,
                    // make nums[i] the new max
                    length=2
                    max = nums[i]
                }
                nums[i] <= min -> {
                    // make nums[i] the new min
                    // but don't change the length
                    min = nums[i]
                }
            }

        }

        // found no triplet!
        return false
    }
}
