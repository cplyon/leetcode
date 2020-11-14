fun main() {
    val beginWord = "hit"
    val endWord = "cog"
    val wordList = listOf<String>("hot","dot","dog","lot","log","cog")
    println(ladderLength(beginWord, endWord, wordList))
}

fun ladderLength(beginWord: String, endWord: String, wordList: List<String>): Int {
    // bail early if:
    // begin & end are the same,
    // either of them are empty
    // end is not in the wordList
    if (beginWord == endWord || beginWord.length == 0 || endWord.length == 0 || endWord !in wordList) {
        return 0
    }

    // populate map of word combinations
    // for every word in wordlist, substitute one letter at a time for a wildcard char
    // then map the new word to a list of all words that match the wildcard
    // for example, "h*t" -> ["hat", "hit", "hot", "hut"]
    val wildcard = '*'
    val combos = HashMap<String, MutableList<String>>()
    for (word in wordList) {
        for (i in word.indices) {
            val newWord = word.substring(0, i) + wildcard + word.substring(i+1)
            val matchingWords = combos.getOrDefault(newWord, mutableListOf<String>())
            matchingWords.add(word)
            combos.put(newWord, matchingWords)
        }
    }

    // Perform a breadth-first-search for endWord starting with startWord
    // store both the word and the number of transformations
    val queue = ArrayDeque<Pair<String, Int>>()
    queue.addFirst(Pair<String, Int>(beginWord, 2))
    var newWord : String
    while (queue.isNotEmpty()) {
        val (word, transformationLength) = queue.removeLast()
        for (i in word.indices) {
            newWord = word.substring(0, i) + wildcard + word.substring(i + 1)
            if (combos.contains(newWord)) {
                for (w in combos[newWord]!!) {
                    if (w == endWord) {
                        // we found the path!
                        return transformationLength
                    }
                    // haven't found the path yet, so add this level of words
                    queue.addFirst(Pair<String, Int>(w, transformationLength + 1))
                }
            }
            // we've exhausted all the words at this level, so remove from the map
            combos.remove(newWord)
        }
    }

    // no path from startWord to endWord was found
    return 0
}