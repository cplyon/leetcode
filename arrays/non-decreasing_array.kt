fun main() {
    val nums = intArrayOf(5,7,1,2)
    println(checkPossibility(nums))
}


fun checkPossibility(nums: IntArray): Boolean {    
    if (nums.size <= 2) {
        return true
    }
    
    if (check(nums)) {
        return true
    }
    
    for (i in nums.indices) {
        val temp = nums[i]
        if (i > 0) {
            nums[i] = nums[i-1]
            if (check(nums)) {
                return true
            }
            nums[i] = temp
        }
        
        if (i < nums.size-1) {
            nums[i] = nums[i+1]
            if (check(nums)) {
                return true
            }     
            nums[i] = temp
        }
        
    }
    
    return false
}

fun check(nums: IntArray) : Boolean {
    for (i in 0..nums.size-2) {
        if (nums[i] > nums[i+1]) {
            return false
        }
    }
    return true
}