fun main() {
    var obj = MinStack()
    obj.push(1)
    obj.push(0)
    println("min: ${obj.getMin()}")
    obj.pop()
    println("top: ${obj.top()}")
    println("min: ${obj.getMin()}")
}

class MinStack() {
    val values = ArrayDeque<Int>()
    val mins = ArrayDeque<Int>()

    fun push(x: Int) {
        values.addFirst(x)
        if (mins.isEmpty() || x <= mins.first()) {
            mins.addFirst(x)
        }
    }

    fun pop() {
        val x = values.removeFirst()
        if (x == mins.first()) {
            mins.removeFirst()
        }
    }

    fun top(): Int {
        return values.first()
    }

    fun getMin(): Int {
        return mins.first()
    }

}

/**
 * Your MinStack object will be instantiated and called as such:
 * var obj = MinStack()
 * obj.push(x)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */