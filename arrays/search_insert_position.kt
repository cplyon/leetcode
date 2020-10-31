fun main() {

    val nums = intArrayOf(2,4,6,8,10)
    val target = 5

    for (i in 1..11) {
        println("$i ${searchInsert(nums, i)}")
    }

}


fun searchInsert(nums: IntArray, target: Int): Int {
    
    if (nums.size == 0) {
        return 0
    }

    if (nums.size == 1) {
        if (nums[0] > target) {
            return 1
        } else {
            return 0
        }
    }

    var midPoint = nums.size / 2
    var upperBound = nums.size
    var lowerBound = 1
    var lastMid = -1

    while (lastMid != midPoint) {
        lastMid = midPoint

        if (target == nums[midPoint]) {
            return midPoint
        }

        if (target < nums[midPoint]) {
            upperBound = midPoint
            midPoint = (midPoint - lowerBound) / 2 + lowerBound
        } else {
            lowerBound = midPoint
            midPoint = (upperBound - midPoint) / 2 + midPoint
        }

    }

    if (nums[midPoint] > target && nums[midPoint-1] >= target)
        return midPoint - 1

    if (nums[midPoint] < target) {
        return midPoint + 1
    }

    return midPoint

}