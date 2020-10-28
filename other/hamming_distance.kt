fun main() {
    val x = 1
    val y = -1
    println(hammingDistance(x, y))
}

fun hammingDistance(x: Int, y: Int): Int {
    var distance = 0

    for (i in 0 until Int.SIZE_BITS) {
        val mask = 1.shl(i)
        if (x and mask != y and mask) {
            distance++
        }
    }    

    return distance
}