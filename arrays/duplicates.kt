fun main() {
    val nums = mutableListOf<Int>(1,4,2,3)
    println(containsDuplicate(nums.toIntArray()))
    println(containsDuplicate2(nums.toIntArray()))
}

fun containsDuplicate(nums: IntArray): Boolean {
    val s = mutableSetOf<Int>()
    nums.forEach {
        s.add(it)
    }
    return s.size != nums.size
}

fun containsDuplicate2(nums: IntArray): Boolean {
    val s = mutableSetOf<Int>()
    nums.forEach {
        if (s.contains(it)) {
            return true
        }
        s.add(it)
    }
    return false
}