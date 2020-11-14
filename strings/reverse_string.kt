fun main() {
    val s = charArrayOf('h','e','l','l','o')
    reverseString(s)
    println(s)
}

fun swap(s: CharArray, i: Int, j: Int) {
    val temp = s[i]
    s[i] = s[j]
    s[j] = temp
}

fun reverseString(s: CharArray): Unit {
    if (s.size == 0) return
    for (i in 0..(s.size-1)/2) {
        swap(s, i, s.size-1-i)
    }
}