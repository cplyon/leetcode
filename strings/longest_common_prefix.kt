fun main() {
    val strs = arrayOf<String>("race","race","a")
    println(longestCommonPrefix(strs))

}

fun longestCommonPrefix(strs: Array<String>): String {
    var longestPrefix = ""
    var currentPrefix = ""
    var abort = false
    var i = 0

    if (strs.size == 0) {
        abort = true
    }

    while (!abort) {
        for (s in strs) {
            if (i >= s.length) {
                currentPrefix = ""
                abort = true
                break
            }
            if (i >= currentPrefix.length) {
                currentPrefix += s[i].toString()
            }
            if (currentPrefix.last() != s[i]) {
                currentPrefix = ""
                abort = true
                break
            }   
        }
        if (currentPrefix.length > longestPrefix.length) {
            longestPrefix = currentPrefix
        }
        i++
    }

    return longestPrefix
}