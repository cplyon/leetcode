fun main() {
    val numRows = 5
    println(generate(numRows))

}

fun generate(numRows: Int): List<List<Int>> {
    val triangle = mutableListOf<List<Int>>()

    if (numRows > 0) {
        var newRow = generate_row(mutableListOf<Int>())
        triangle.add(newRow)
        for (i in 2..numRows) {
            newRow = generate_row(newRow)
            triangle.add(newRow)
        }
    }

    return triangle
}

fun generate_row(prevRow: List<Int>) : List<Int> {

    if (prevRow.size == 0) {
        return listOf<Int>(1)
    }

    if (prevRow.size == 1) {
        return listOf<Int>(1,1)
    }

    val newRow = mutableListOf<Int>()

    // populate first half
    newRow.add(prevRow[0])
    for (i in 1 until (prevRow.size/2)) {
        newRow.add(prevRow[i] + prevRow[i-1])
    }
    
    // populate middle element
    newRow.add(prevRow[(prevRow.size/2)-1] + prevRow[(prevRow.size/2)])

    // populate last half
    for (i in (prevRow.size/2) until prevRow.size-1) {
        newRow.add(prevRow[i] + prevRow[i+1])
    }
    newRow.add(prevRow[prevRow.size-1])

    return newRow
}