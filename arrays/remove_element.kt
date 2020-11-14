fun main() {

    val nums = intArrayOf(0,1,2,2,3,0,4,2)
    val v = 2
    println(removeElement2(nums, v))
    printArray(nums)

}


fun printArray(array: IntArray) = array.forEach {
    print("$it ")
}

fun removeElement(nums: IntArray, `val`: Int): Int {
    var newLength = nums.size
    for (i in nums.size-1 downTo 0) {
        if (nums[i] == `val`) {
            newLength--
            // shift all elements to the right down one
            for (j in i..nums.size-2) {
                nums[j] = nums[j+1]
            }
        }
    }

    return newLength
}