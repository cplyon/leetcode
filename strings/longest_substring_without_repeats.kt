fun main() {
    val s = Solution()
    var input = "abcabcbb"
    println("$input ${s.lengthOfLongestSubstring(input)}")
    input = "bbbbb"
    println("$input ${s.lengthOfLongestSubstring(input)}")
    input = "pwwkew"
    println("$input ${s.lengthOfLongestSubstring(input)}")
    input = ""
    println("$input ${s.lengthOfLongestSubstring(input)}")
    input = "ckilbkd"
    println("$input ${s.lengthOfLongestSubstring(input)}")
    input = "dvdf"
    println("$input ${s.lengthOfLongestSubstring(input)}")
    input = "aab"
    println("$input ${s.lengthOfLongestSubstring(input)}")
    input = "ohvhjdml"
    println("$input ${s.lengthOfLongestSubstring(input)}")
    input = "aabaab!bb"
    println("$input ${s.lengthOfLongestSubstring(input)}")

}


class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        var maxLength = 0
        val chars = mutableSetOf<Char>()
        var sequenceStartIndex = 0
        for (c in s) {
            if (c !in chars) {
                // haven't seen c before
                // add it to sequence
                chars.add(c)
            } else {
                // seen c before
                // resize the sequence by removing all chars up to the first appearance of c
                for (j in sequenceStartIndex until s.indexOf(c, sequenceStartIndex)) {
                    chars.remove(s[j])
                    sequenceStartIndex++
                }
                sequenceStartIndex++
            }
            // store the max sequence length seen so far
            maxLength = maxOf(maxLength, chars.size)
        }
        return maxLength
    }
}