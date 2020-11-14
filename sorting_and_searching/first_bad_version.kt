fun main() {
    println(firstBadVersion_recursive(10))
    println(firstBadVersion_iterative(10))
}

fun isBadVersion(version: Int): Boolean {
    return (version >= 7)
}


fun firstBadVersion_recursive(n: Int) : Int {
    return firstBadVersion_helper(1..n)
}

fun firstBadVersion_helper(range: IntRange): Int {
    if (range.count() <= 2) {
        if (isBadVersion(range.first)) return range.first
        if (isBadVersion(range.last)) return range.last
    }

    val midPoint = (range.last - range.first) / 2 + range.first
    if (isBadVersion(midPoint)) {
        return firstBadVersion_helper(range.first until midPoint)
    }
    return firstBadVersion_helper(midPoint+1..range.last)
}


fun firstBadVersion_iterative(n: Int) : Int {
    var midPoint = n / 2
    var upperBound = n
    var lowerBound = 1
    while (midPoint < n) {
        if (isBadVersion(midPoint)) {
            // first bad must be <= midPoint
            if (!isBadVersion(midPoint - 1)) {
                return midPoint
            }
            upperBound = midPoint
            midPoint = (midPoint - lowerBound) / 2 + lowerBound
        } else {
            // first bad must be > midPoint
            if (isBadVersion(midPoint + 1)) {
                return midPoint + 1
            }
            lowerBound = midPoint
            midPoint = (upperBound - midPoint) / 2 + midPoint
        }

    }
    return n   
}