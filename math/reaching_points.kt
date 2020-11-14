fun main() {
    println(reachingPoints_bfs(1,1,5,8))
    println(reachingPoints_dfs(1,1,5,8))
    println(reachingPoints_recursive(1,1,5,8))
    println(reachingPoints_backwards(1,1,5,8))
}


fun reachingPoints_bfs(sx: Int, sy: Int, tx: Int, ty: Int): Boolean {
    val queue = ArrayDeque<Pair<Int, Int>>()
    queue.addFirst(Pair<Int, Int>(sx, sy))

    while (queue.isNotEmpty()) {
        val curPair = queue.removeLast()
        if (curPair.first == tx && curPair.second == ty) {
            // we found it!
            return true
        }

        if (curPair.first > tx || curPair.second > ty) {
            // we overshot it!
            continue
        }

        // try the next two moves
        val nextPair1 = Pair<Int, Int>(curPair.first, curPair.second + curPair.first)
        queue.addFirst(nextPair1)
        val nextPair2 = Pair<Int, Int>(curPair.first + curPair.second, curPair.second)
        queue.addFirst(nextPair2)
    }

    // no path was found
    return false
}

fun reachingPoints_dfs(sx: Int, sy: Int, tx: Int, ty: Int): Boolean {
    val stack = ArrayDeque<Pair<Int, Int>>()
    stack.addFirst(Pair<Int, Int>(sx, sy))

    while (stack.isNotEmpty()) {
        val curPair = stack.removeFirst()
        if (curPair.first == tx && curPair.second == ty) {
            // we found it!
            return true
        }

        if (curPair.first > tx || curPair.second > ty) {
            // we overshot it!
            continue
        }

        // try the next two moves
        val nextPair1 = Pair<Int, Int>(curPair.first, curPair.second + curPair.first)
        stack.addFirst(nextPair1)
        val nextPair2 = Pair<Int, Int>(curPair.first + curPair.second, curPair.second)
        stack.addFirst(nextPair2)
    }

    // no path was found
    return false
}

fun reachingPoints_recursive(sx: Int, sy: Int, tx: Int, ty: Int): Boolean {
    if (sx == tx && sy == ty) {
        // we found it!
        return true
    }

    if (sx > tx || sy > ty) {
        // we overshot it!
        return false
    }

    return reachingPoints_recursive(sx, sy+sx, tx, ty) || reachingPoints_recursive(sx+sy, sy, tx, ty)
}

fun reachingPoints_backwards(sx: Int, sy: Int, tx: Int, ty: Int): Boolean {
    var curX = tx
    var curY = ty
    while (curX >= sx && curY >= sy) {
        if (curX == sx && curY == sy) {
            // we found it!
            return true
        }

        if (curX > curY) {
            curX -= curY
        } else {
            curY -= curX
        }
    }
    return false
}