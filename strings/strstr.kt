fun main() {
    val haystack = "mississippi"
    val needle = "issippi"    
    println(strStr(haystack, needle))
}

fun strStr(haystack: String, needle: String): Int {
    if (needle.length == 0) {
        return 0
    }

    if (needle.length > haystack.length) {
        return -1
    }

    var i = -1
    var j = 0
    var firstIndex = -1
    while (j < haystack.length) {
        i++
        if (needle[i] == haystack[j]) {
            if (firstIndex == -1) {
                firstIndex = j
            }
            if (i == (needle.length - 1) && (firstIndex > -1)) {
                break
            }            
        } else {
            i = -1
            if (firstIndex != -1) {
                j = firstIndex
            }
            firstIndex = -1
        }
        j++
    }

    if (j == haystack.length && i != needle.length) {
        return -1
    }

    return firstIndex

}