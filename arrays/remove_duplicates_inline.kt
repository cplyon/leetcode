fun main() {
    val arr = intArrayOf(1, 1, 1, 1, 0, 0, 0, 2, 3, 4, 4)
    println(removeDuplicates(arr))
    printArray(arr)
}

fun printArray(array: IntArray) = array.forEach {
    print("$it ")
}

// space complexity of O(1)
// time complexity of O(n)
fun removeDuplicates(nums: IntArray) : Int {

    var lastUniqueIndex = 0
    for (i in 1..nums.size-1) {
        if (nums[i] != nums[i-1]) {
            lastUniqueIndex++
            nums[lastUniqueIndex] = nums[i]
        }
    }

    return lastUniqueIndex+1
}