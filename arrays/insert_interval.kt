fun main() {
    val intervals = arrayOf<IntArray>(intArrayOf(1,2), intArrayOf(3,5), intArrayOf(6,7), intArrayOf(8,10), intArrayOf(12,16))
    val newInterval = intArrayOf(4,8)
    printList(insert(intervals, newInterval))
}

fun printList(array: Array<IntArray>) {
    print("[")
    array.forEach { subArray ->
        print("[")
        subArray.forEach {
            print("$it ")
        }
        print("] ")
    }
    print("] ")
    println()
}

/*
Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
    0 <= intervals.length <= 104
    intervals[i].length == 2
    0 <= intervals[i][0] <= intervals[i][1] <= 105
    intervals is sorted by intervals[i][0] in ascending order.
    newInterval.length == 2
    0 <= newInterval[0] <= newInterval[1] <= 105
 */

fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {

    val returnIntervals = mutableListOf<IntArray>()

    // first, insert newInterval into existing list at correct place
    // ordered by interval starts
    var added = false
    intervals.forEach { interval ->
        if (newInterval[0] <= interval[0]) {
            returnIntervals.add(newInterval)
            added = true
        }
        returnIntervals.add(interval)
    }
    if (!added) {
        returnIntervals.add(newInterval)
    }

    // next, extend or merge intervals
    var i = 0
    while (i < returnIntervals.size-1) {
        val curInterval = returnIntervals[i]
        val nextInterval = returnIntervals[i+1]

        if (curInterval[1] >= nextInterval[0]) {
            if (curInterval[1] > nextInterval[1]) {
                // curInterval absorbs nextInterval
                returnIntervals.removeAt(i+1)
            } else {
                // curInterval extends to nextInterval
                curInterval[1] = nextInterval[1]
                returnIntervals.removeAt(i+1)
            }
        } else {
            // interval is in correct place, move to next
            i++
        }
    }

    return returnIntervals.toTypedArray()
}
