fun main() {
    val heights = intArrayOf()
    println(heightChecker(heights))
}

fun heightChecker(heights: IntArray): Int {
    var numMoves = 0
    val newHeights = heights.sortedArray() 
    for (i in heights.indices) {
        if (heights[i] != newHeights[i]) {
            numMoves++
        }
    }
    
    return numMoves
}