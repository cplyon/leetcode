fun main() {
    val s = "d"
    val t = "e"
    println(isAnagram(s, t))

}

fun isAnagram(s: String, t: String): Boolean {
    if (s.length != t.length) {
        return false
    }

    if (s.length == 1) {
        return s == t
    }

    val charCounts = mutableMapOf<Char, Int>()
    for (c in s) {
        charCounts.put(c, charCounts.getOrDefault(c, 0) + 1)
    }

    for (c in t) {
        val count = charCounts.getOrDefault(c, 0)
        if (count <= 0) {
            // found character in t not in s
            return false
        }
        charCounts.put(c, count-1)
    }

    return true
}