fun main() {

    val x = Int.MAX_VALUE
    println(isPalindrome(x))

}

fun isPalindrome(x: Int): Boolean {
    if (x < 0) {
        return false
    }

    var reversed: Long = 0
    var original = x
    while (original > 0) {
        reversed *= 10
        reversed += original % 10
        original /= 10
    }

    if (reversed > Int.MAX_VALUE) {
        return false
    }

    return (reversed.toInt() == x)
}