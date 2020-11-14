fun main() {
    val nums = intArrayOf(1,1,2,3,3)
    println(singleNumber(nums))
}

fun singleNumber(nums: IntArray): Int {
    val s = mutableSetOf<Int>()
    nums.forEach {
         if (s.contains(it)) {
            s.remove(it)
         } else {
            s.add(it)
         }
    }

    return s.first()
}