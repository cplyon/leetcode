fun main() {

    val n = 43261596
    println(Integer.toBinaryString(n))
    println(Integer.toBinaryString(reverseBits(n)))

}

fun reverseBits(n:Int):Int {
    var reversed = 0

    for (i in 0..Int.SIZE_BITS) {
        if (n and 1.shl(i) != 0) {
            reversed = reversed or 1.shl(Int.SIZE_BITS-1-i)
        }
    }

    return reversed
}