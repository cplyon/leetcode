fun main() {
    val s = Solution()
    //val words = arrayOf<String>("h", "ha", "he", "his", "hel", "banana")
    val words = arrayOf<String>("a","banana","app","appl","ap","apply","apple")
    //val words = arrayOf<String>("a")
    println(s.longestWord(words))
}

class Solution {
    fun longestWord(words: Array<String>): String {

        // input validation
        if (words.isEmpty()) return ""

        // populate the trie
        // O(n*m) - n = # words, m = length of longest word
        val root = TrieNode(null)
        for (word in words) {
            var cur = root
            for (c in word) {
                if (c !in cur.nodes) {
                    val newNode = TrieNode(c)
                    cur.nodes.put(c, newNode)
                }
                cur = cur.nodes[c]!!
            }
            cur.word = word
        }

        // retrieve longest word
        return dfs(root)
    }


    fun dfs(root: TrieNode) : String {

        var maxWord = ""
        val stack = ArrayDeque<TrieNode>()
        for (v in root.nodes.values) {
            stack.addFirst(v)
        }
        while (stack.isNotEmpty()) {
            var cur = stack.removeFirst()
            if (cur.word != "") {
                if (cur.word.length > maxWord.length) {
                    maxWord = cur.word
                } else if (cur.word.length == maxWord.length) {
                    if (maxWord.compareTo(cur.word) > 0) {
                        maxWord = cur.word
                    }
                }
                for (v in cur.nodes.values) {
                    stack.addFirst(v)
                }
            }
        }
        return maxWord
    }

}

class TrieNode(val `val`: Char?) {
    val nodes = mutableMapOf<Char, TrieNode>()
    var word = ""
}