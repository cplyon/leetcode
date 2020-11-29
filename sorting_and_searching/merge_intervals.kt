fun main() {
    val s = Solution()
    val intervals = arrayOf<IntArray>(
        intArrayOf(10,30),
        intArrayOf(2,6),
        intArrayOf(8,10),
        intArrayOf(15,18)
        )

    val results = s.merge(intervals)
    results.forEach { result ->
        print("[")
        result.forEach {
            print("$it ")
        }
        print("] ")
    }
    println()
}

class Solution {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        // O(nlogn)
        if (intervals.isEmpty()) {
            return emptyArray()
        }
        val sortedIntervals = intervals.sortedBy { it[0] }
        val result = mutableListOf<IntArray>()

        var start = sortedIntervals[0][0]
        var end = sortedIntervals[0][1]
        for (i in 1..sortedIntervals.size-1) {
            if (sortedIntervals[i][0] <= end) {
                end = maxOf(end, sortedIntervals[i][1])
            } else {
                result.add(intArrayOf(start, end))
                start = sortedIntervals[i][0]
                end = sortedIntervals[i][1]
            }
        }
        result.add(intArrayOf(start, end))
        return result.toTypedArray()
    }
}