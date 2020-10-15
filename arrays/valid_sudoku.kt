fun main() {
    val board = arrayOf<CharArray>(
    charArrayOf('5','3','.','.','7','.','.','.','.'),
    charArrayOf('6','.','.','1','9','5','.','.','.'),
    charArrayOf('.','9','8','.','.','.','.','6','.'),
    charArrayOf('8','.','.','.','6','.','.','.','3'),
    charArrayOf('4','.','.','8','.','3','.','.','1'),
    charArrayOf('7','.','.','.','2','.','.','.','6'),
    charArrayOf('.','6','.','.','.','.','2','8','.'),
    charArrayOf('.','.','.','4','1','9','.','.','5'),
    charArrayOf('.','.','.','.','8','.','.','7','9')
    )
    print(isValidSudoku(board))

}

fun isValidSudoku(board: Array<CharArray>): Boolean {
    return (checkHorizontals(board) && checkVerticals(board) && checkSubBoxes(board))
}

fun checkHorizontals(board: Array<CharArray>): Boolean {
    var valueMap : MutableSet<Char>
    for (horizontal in board) {
        valueMap = mutableSetOf<Char>()
        for (h in horizontal) {
            if (h != '.') {
                if (valueMap.contains(h)) {
                    return false
                }
                valueMap.add(h)
            }
        }
    }
    return true
}

fun checkVerticals(board: Array<CharArray>): Boolean {
    var valueMap : MutableSet<Char>
    for (i in board[0].indices) {
        valueMap = mutableSetOf<Char>()
        for (j in board.indices) {
            if (board[j][i] != '.') {
                if (valueMap.contains(board[j][i])) {
                    return false
                }
                valueMap.add(board[j][i])                
            }
        }
    }

    return true
}

fun checkSubBoxes(board: Array<CharArray>): Boolean {
    for (i in 0..6 step 3) {
        for (j in 0..6 step 3) {
            if (!checkSubBox(board, i, j)) {
                return false
            }
        }
    }
    return true
}

fun checkSubBox(board: Array<CharArray>, x: Int, y:Int): Boolean {
    val valueMap = mutableSetOf<Char>()
    for (i in x..x+2) {
        for (j in y..y+2) {
            if (board[j][i] != '.') {
                if (valueMap.contains(board[j][i])) {
                    return false
                }
                valueMap.add(board[j][i])  
            }  
        }
    }
    return true
}