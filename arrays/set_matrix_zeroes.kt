fun main() {
    val s = Solution()
    val matrix = arrayOf<IntArray>(
        intArrayOf(1,1,1,1),
        intArrayOf(1,0,1,1),
        intArrayOf(1,1,1,1))
    s.setZeroes(matrix)
    printMatrix(matrix)
}

fun printMatrix(matrix: Array<IntArray>) {
    matrix.forEach {
        it.forEach {
            print("$it ")
        }
        println()
    }    
}

class Solution {

    // O(m+n) space
    fun setZeroes(matrix: Array<IntArray>): Unit {

        val cols = mutableListOf<Int>()
        val rows = mutableListOf<Int>()
        
        for (c in matrix.indices) {
            for (r in matrix[c].indices) {
                if (matrix[c][r] == 0) {
                    cols.add(c)
                    rows.add(r)
                }
            }
        }

        for (c in matrix.indices) {
            for (r in matrix[c].indices) {
                if (c in cols) {
                    matrix[c][r] = 0
                }            
            }
        }

        for (r in matrix[0].indices) {
            for (c in matrix.indices) {
                if (r in rows) {
                    matrix[c][r] = 0
                }   
            }
        }        

    }
}