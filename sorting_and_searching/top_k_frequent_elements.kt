import java.util.PriorityQueue

fun main() {
    val s = Solution()
    val nums = intArrayOf(3,0,1,0)
    val k = 1
    var result = s.topKFrequent(nums, k)
    result.forEach { print("$it ") }
    println()
    result = s.topKFrequent2(nums, k)
    result.forEach { print("$it ") }
    println()

}

class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        // O(nlogn) time, O(n) space
        if (nums.size <= 1) {
            return nums
        }

        // map elements to their frequencies
        val frequencies = mutableMapOf<Int, Int>().withDefault( { 0 } )
        for (n in nums) {
            frequencies.put(n, frequencies.getValue(n) + 1)
        }

        // sort map by frequencies
        val sortedList = frequencies.entries.toMutableList()
        sortedList.sortBy { it.value }

        // return last k items
        return sortedList.slice(sortedList.size-k until sortedList.size).map { it.key }.toIntArray()
    }


    fun topKFrequent2(nums: IntArray, k: Int): IntArray {
        // O(nlogn) time, O(n) space
        if (nums.size <= 1) {
            return nums
        }

        // map elements to their frequencies
        val frequencies = mutableMapOf<Int, Int>().withDefault( { 0 } )
        for (n in nums) {
            frequencies.put(n, frequencies.getValue(n) + 1)
        }

        // use a Priority Queue to store the elements by frequency
        val pq = PriorityQueue<Pair<Int, Int>>(frequencies.size, compareByDescending {it.second} )
        for (f in frequencies.entries) {
            pq.add(Pair(f.key, f.value))
        }

        val result = mutableListOf<Int>()
        for (i in 0 until k) {
            result.add(pq.poll().first)
        }

        // return first k items
        return result.toIntArray()
    }
}