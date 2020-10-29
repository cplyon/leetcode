fun main() {
    val n = 10
    println(climbStairs_1(n))   
}

fun climbStairs_1(n: Int): Int {
    // the number of steps mirrors the Fibonacci sequence
    // so store all previous results in a table
    // this runs in O(n) time
    val steps = mutableListOf<Int>(1,2)
    for (i in 2..n) {
        steps.add(steps[i-1] + steps[i-2])
    }
    return steps[n-1]
}

fun climbStairs_2(n: Int): Int {
    // construct the set of all combinations and count them
    // this runs in O(2^n) time
    var cur = setOf<String>()
    for (i in 1..n) {
        cur = generate_row(cur, i)
    }
    return cur.size
}

fun generate_row(prev: Set<String>, n: Int) : Set<String> {

    // add string of n "1"s to our set
    val next = mutableSetOf<String>("1".repeat(n))

    for (way in prev) {
        // replace every "1" with a "2" in each of the previous ways
        // then add to our set
        for (i in way.indices) {            
            if (way[i] == '1') {
                var newWay = StringBuilder(way)
                newWay.setCharAt(i, '2')
                next.add(newWay.toString())
            }
        }
    }

    return next
}