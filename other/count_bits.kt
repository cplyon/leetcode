fun main() {
    val n = 0
    println(hammingWeight(n))
}

fun hammingWeight(n:Int): Int {
    var numBits = 0
    for (i in 0 until Int.SIZE_BITS) {
        if (n and 1.shl(i) != 0) {
            numBits++
        }
    }
    return numBits
}