fun main() {

    val s = "hello world   "
    println(lengthOfLastWord(s))

}

fun lengthOfLastWord(s: String): Int {
    
    var length = 0
    for (i in s.length-1 downTo 0) {
        if (s[i] != ' ') {
            length++
        } else if (length != 0) {
            break    
        }
    }

    return length

}