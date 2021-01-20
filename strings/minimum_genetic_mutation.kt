fun main() {

    val start = "AACCGGTT"
    val end = "AAACGGTA"
    val bank = arrayOf<String>("AACCGGTA", "AACCGCTA", "AAACGGTA")

    println(minMutation(start, end, bank))
}

/*
    * Starting point is assumed to be valid, so it might not be included in the bank.
    * If multiple mutations are needed, all mutations during in the sequence must be valid.
    * You may assume start and end string is not the same.
*/

fun minMutation(start: String, end: String, bank: Array<String>): Int {
    if (end !in bank) {
        return -1
    }

    val allCombos = mutableMapOf<String, MutableList<String>>()

    // populate dictionary of wildcards
    for (word in bank) {
        for (i in start.indices) {
            val wordArray = word.toCharArray()
            wordArray[i] = '*'
            val newWord = String(wordArray)
            if (!allCombos.containsKey(newWord)) {
                allCombos[newWord] = mutableListOf<String>()
            }
            allCombos[newWord]!!.add(word)
        }
    }

    val queue = ArrayDeque<Pair<String, Int>>()
    queue.addFirst(Pair<String, Int>(start, 1))

    while (queue.isNotEmpty()) {
        val (currentWord, level) = queue.removeLast()
        for (i in start.indices) {
            val wordArray = currentWord.toCharArray()
            wordArray[i] = '*'
            val newWord = String(wordArray)
            if (!allCombos.containsKey(newWord)) continue
            val combos = allCombos[newWord]!!
            for (word in combos) {
                if (word == end) {
                    // we found it!
                    return level
                }
                queue.addFirst(Pair<String, Int>(word, level+1))
            }
            allCombos[newWord] = mutableListOf<String>()
        }
    }
    return -1
}