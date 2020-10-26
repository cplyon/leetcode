import kotlin.random.Random

fun main() {
    val nums = intArrayOf(-6,10,184)
    var obj = Solution(nums)
    obj.reset().forEach{ print(it) }
    println()
    obj.shuffle().forEach{ print(it) }
    println()
    obj.reset().forEach{ print(it) }
    println()
    obj.shuffle().forEach{ print(it) }
    println()
    obj.reset().forEach{ print(it) }
    println()
    obj.shuffle().forEach{ print(it) }
    println()
    obj.reset().forEach{ print(it) }
    println()
    obj.shuffle().forEach{ print(it) }
    println()
}

class Solution(nums: IntArray) {

    private val original = nums

    /** Resets the array to its original configuration and return it. */
    fun reset(): IntArray {
        return original
    }

    private fun swap(array: IntArray, a: Int, b: Int) {
        val temp = array[a]
        array[a] = array[b]
        array[b] = temp
    }

    /** Returns a random shuffling of the array. */
    fun shuffle(): IntArray {
        val shuffled = original.copyOf()
        for (i in shuffled.lastIndex downTo 1) {
            swap(shuffled, i, Random.nextInt(i+1))
        }
        return shuffled
    }

}