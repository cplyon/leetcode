fun main() {
    val s = "leetcode"
    println(firstUniqChar(s))
}


fun firstUniqChar(s: String): Int {

    if (s.length == 0) {
        return -1
    } else if (s.length == 1) {
        return 0
    }

    val charCounts = HashMap<Char, Int>()
    for (c in s) {
        charCounts.put(c, charCounts.getOrDefault(c, 0) + 1)
    }

    for ((i, c) in s.withIndex()) {
        if (charCounts[c] == 1) {
            return i
        }
    }

    return -1

}