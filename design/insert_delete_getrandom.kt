fun main() {
    val r = RandomizedSet()

    println(r.remove(4)) // false
    println(r.insert(4)) // true
    println(r.insert(4)) // false
    println(r.insert(9)) // true
    println(r.remove(9)) // true
    println(r.getRandom())
}


class RandomizedSet() {

    /** Initialize your data structure here. */
    val values = mutableMapOf<Int, Int>()
    val random = mutableListOf<Int>()


    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    fun insert(`val`: Int): Boolean {
        // O(1) time, O(n) space

        // val already in the set, so return false
        if (`val` in values) return false

        // map val to the last index in random
        values[`val`] = random.size
        // append val to random
        random.add(`val`)

        return true
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    fun remove(`val`: Int): Boolean {
        // O(1) time, O(n) space

        // val not in set, so return false
        if (`val` !in values) return false

        // get the index into random for this value
        val rIndex = values[`val`]!!
        // remove val from the set
        values.remove(`val`)

        // replace the value in random with the last value
        random[rIndex] = random[random.size-1]
        // remove the last value from random
        random.removeAt(random.size-1)

        // if the removed value wasn't the last one in random,
        // update the map for the newly moved value in random
        if (rIndex < random.size ) {
            values[random[rIndex]] = rIndex
        }

        return true
    }

    /** Get a random element from the set. */
    fun getRandom(): Int {
        // O(1) time, O(n) space

        // throw if set is empty
        if (random.size <= 0) {
            throw Exception("Empty Set")
        }

        return random[(0 until random.size).random()]
    }

}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * var obj = RandomizedSet()
 * var param_1 = obj.insert(`val`)
 * var param_2 = obj.remove(`val`)
 * var param_3 = obj.getRandom()
 */