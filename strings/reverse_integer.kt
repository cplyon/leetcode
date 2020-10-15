fun main() {
    val x: Int = 1234
    println(reverse(x))
}


fun reverse(x: Int): Int {
    
    var y: Long = if (x < 0) {
        -x.toLong()
    } else {
        x.toLong()
    }

    var s = ""
    while (y >= 10) {
        s = s.plus((y - (y /10 * 10)).toString())
        y = y / 10
    }
    y = s.plus(y).toLong()
    if (y > Integer.MAX_VALUE || y < Integer.MIN_VALUE) return 0


    if (x < 0) {
        return -y.toInt()
    }

    return y.toInt()
}