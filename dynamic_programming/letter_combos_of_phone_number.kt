fun main() {
    val s = Solution()
    val digits = "222"
    println(s.letterCombinations(digits))
}

class Solution {

    val letterMap = mapOf<Char, List<String>>(
        '2' to listOf<String>("a", "b", "c"),
        '3' to listOf<String>("d", "e", "f"),
        '4' to listOf<String>("g", "h", "i"),
        '5' to listOf<String>("j", "k", "l"),
        '6' to listOf<String>("m", "n", "o"),
        '7' to listOf<String>("p", "q", "r", "s"),
        '8' to listOf<String>("t", "u", "v"),
        '9' to listOf<String>("w", "x", "y", "z")
    ).withDefault({listOf<String>()})

    fun letterCombinations(digits: String): List<String> {

        // base case 1: empty input
        if (digits.isNullOrEmpty()) {
            return listOf<String>()
        }

        // base case 2: single digit
        val letters = letterMap.getValue(digits[0])
        if (digits.length == 1) {
            return letters
        }

        // get letters for first digit, prepend to result of recurse with rest of string
        val combos = mutableListOf<String>()
        letters.forEach { curLetter ->
            letterCombinations(digits.substring(1)).forEach { nextLetters ->
                combos.add(curLetter + nextLetters)
            }
        }
        return combos
    }
}