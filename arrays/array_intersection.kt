fun main() {
    val nums1 = intArrayOf(2,2)
    val nums2 = intArrayOf(2,1)
    intersect(nums1, nums2).forEach { print("$it ") }
    println()
}

fun intersect(nums1: IntArray, nums2: IntArray) : IntArray {
    var intersection = mutableListOf<Int>()
    if (nums1.size > 0 && nums2.size > 0) {
        var nums1_counts = HashMap<Int, Int>(nums1.size)
        for (n in nums1) {
            nums1_counts.put(n, nums1_counts.getOrDefault(n, 0) + 1)    
        }

        for (n in nums2) {
            val count = nums1_counts.getOrDefault(n, 0)
            if (count > 0) {
                intersection.add(n)
                nums1_counts.put(n, count - 1)
            }    
        }
    }
    return intersection.toIntArray()
}
