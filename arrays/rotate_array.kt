fun main() {
    val input = mutableListOf(1,2,3,4,5,6)
    val k = 1
    rotate_inline(input, k)
    input.forEach() {
        print(it)
    }
    println()
    
} 

fun rotate(nums: MutableList<Int>, k: Int) {
    if (k == 0) return
    if (nums.size <= 1) return
    
    val step = k % nums.size
    var new = nums.toMutableList()
    for (i in 0..nums.size-1) {
        new[(i+step) % nums.size] = nums[i]
    }
    for (i in nums.indices) {
       nums[i] = new[i]
    }
}
