fun main() {
    val s = Solution()
    var input = "babad"
    println(s.longestPalindrome(input))
    input = "babab"
    println(s.longestPalindrome(input))
    input = "abbc"
    println(s.longestPalindrome(input))
    input = "bb"
    println(s.longestPalindrome(input))
    input = "a"
    println(s.longestPalindrome(input))
    input = "ac"
    println(s.longestPalindrome(input))
    input = "1234567890f987654321"
    println(s.longestPalindrome(input))
}


class Solution {

    // O(n^2) time, O(1) space
    fun longestPalindrome(s: String): String {

        if (s.length < 2) {
            return s
        }

        var maxSubString = ""
        var curSubString : String
        for (i in s.indices) {
            for (j in s.length - 1 downTo i+1) {
                curSubString = s.substring(i, j+1)
                if (s[i] == s[j]) {
                    if (curSubString == curSubString.reversed()) {
                        if (maxSubString.length < curSubString.length) {
                            maxSubString = curSubString.toString()
                        }
                        if (j == s.length - 1) {
                            // we can return early once the length of maxSubstring
                            // is as long as the remaining string to process
                            return maxSubString
                        }
                    }
                }
            }

        }

        if (maxSubString.isNullOrEmpty()) {
            return s[0].toString()
        }

        return maxSubString

    }
}