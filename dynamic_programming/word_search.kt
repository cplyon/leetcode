fun main() {
    val s = Solution()
    val board = arrayOf(
/*
        charArrayOf('A','B','C','E'),
        charArrayOf('S','F','E','S'),
        charArrayOf('A','D','E','E'),
        */
        charArrayOf('b','a','a','b','a','b'),
        charArrayOf('a','b','a','a','a','a'),
        charArrayOf('a','b','a','a','a','b'),
        charArrayOf('a','b','a','b','b','a'),
        charArrayOf('a','a','b','b','a','b'),
        charArrayOf('a','a','b','b','b','a'),
        charArrayOf('a','a','b','a','a','b')

        )
    //val word = "ABCESEEDAS"
    val word = "aabbbbabb"
    println(s.exist(board, word))

}
/*
Given an m x n board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells,
where 'adjacent' cells are horizontally or vertically neighboring.
The same letter cell may not be used more than once.
    m == board.length
    n = board[i].length
    1 <= m, n <= 200
    1 <= word.length <= 103
    board and word consists only of lowercase and uppercase English letters.
 */
class Solution {

    var board = arrayOf<CharArray>()
    var word = ""
    val visited = mutableSetOf<Pair<Int, Int>>()

    fun exist(board: Array<CharArray>, word: String): Boolean {
        // recursive DFS solution

        if (board.isEmpty() || board.first().isEmpty() || word.isNullOrEmpty()) {
            return false
        }

        this.board = board
        this.word = word

        for (i in board.indices) {
            for (j in board[i].indices) {
                if (dfs(i, j, 0)) {
                    return true
                }
            }
        }

        return false
    }

    fun dfs(i: Int, j: Int, letterIndex: Int): Boolean {

        // make sure we're within the bounds of the board
        if (i < 0 || j < 0 || i >= board.size || j >= board.first().size) {
            return false
        }

        // make sure we're in the bounds of the word
        if (letterIndex < 0 || letterIndex >= word.length) {
            return false
        }

        val curCell = Pair(i,j)

        // this letter doesn't match, so remove from visited and abandon this path
        if (board[i][j] != word[letterIndex]) {
            visited.remove(curCell)
            return false
        }

        // already checked this cell, so abandon this path
        if (curCell in visited) {
            return false
        }

        // at the last letter, so we found the word!
        if (letterIndex == word.length-1) {
            return true
        }

        // mark this cell as visited
        visited.add(curCell)

        // search each adjacent, return true if any of these paths are the right one
        if (dfs(i+1, j, letterIndex+1) || dfs(i, j+1, letterIndex+1) ||
            dfs(i-1, j, letterIndex+1) || dfs(i, j-1, letterIndex+1)) {
                return true
        }

        // didn't find it, so remove from visited and abandon this path
        visited.remove(curCell)
        return false
    }

}