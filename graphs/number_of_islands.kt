fun main() {
    val s = Solution()
    val grid = arrayOf<CharArray>(
        charArrayOf('1','1','1'),
        charArrayOf('0','0','0'),
        charArrayOf('1','1','1')
    )

    println(s.numIslands(grid))
}

/*
    m == grid.length
    n == grid[i].length
    1 <= m, n <= 300
    grid[i][j] is '0' or '1'.
 */
class Solution {
    val checked = mutableSetOf<Pair<Int, Int>>()
    lateinit var grid : Array<CharArray>

    fun numIslands(grid: Array<CharArray>): Int {
        this.grid = grid
        var islandCount = 0
        for (i in grid.indices) {
            for (j in grid[i].indices) {
                val cell = Pair(i, j)
                if (grid[i][j] == '1' && cell !in checked) {
                    visitAdjacents(cell)
                    islandCount++
                }
            }
        }
        return islandCount
    }

    fun visitAdjacents(cell: Pair<Int, Int>) {
        // recursive depth-first traversal solution
        var (i, j) = cell
        if (i < 0 || i > grid.size-1 || j < 0 || j > grid[0].size-1 || grid[i][j] != '1' || cell in checked) {
            return
        }
        checked.add(cell)
        visitAdjacents(Pair(i-1, j))
        visitAdjacents(Pair(i+1, j))
        visitAdjacents(Pair(i, j-1))
        visitAdjacents(Pair(i, j+1))
    }


    fun visitAdjacents2(cell: Pair<Int, Int>) {
        // iterative breadth-first traversal
        val queue = ArrayDeque<Pair<Int, Int>>()

        fun validateCell(cell: Pair<Int, Int>) {
            if (cell !in checked) {
                queue.addFirst(cell)
                checked.add(cell)
            }
        }

        queue.addFirst(cell)
        checked.add(cell)
        while (queue.isNotEmpty()) {
            var (i,j) = queue.removeLast()
            if (i < grid.size-1 && grid[i+1][j] == '1') {
                validateCell(Pair(i+1, j))
            }

            if (i > 0 && grid[i-1][j] == '1') {
                validateCell(Pair(i-1, j))
            }

            if (j < grid[0].size-1 && grid[i][j+1] == '1') {
                validateCell(Pair(i, j+1))
            }

            if (j > 0 && grid[i][j-1] == '1') {
                validateCell(Pair(i, j-1))
            }
        }

    }



}