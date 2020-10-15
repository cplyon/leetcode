fun main() {
    val s = "aa.....4aA"
    println(isPalindrome(s))
}

fun isPalindrome(s: String): Boolean {

    if (s.length <= 1) {
        return true
    }

    var i = 0
    var j = s.length-1
    while (i < j) {
        if (!s[i].isLetterOrDigit()) {
            i++
            continue
        }
        if (!s[j].isLetterOrDigit()) {
            j--
            continue
        }        
        if (s[i].toLowerCase() != s[j].toLowerCase()) {
            return false
        }
        i++
        j--
    }
    return true
}