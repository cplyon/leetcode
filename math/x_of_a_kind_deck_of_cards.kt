fun main() {
    val s = Solution()
    val deck = intArrayOf(1,1,2,2,3,3,3,3,3,3)
    println(s.hasGroupsSizeX(deck))
}

class Solution {
    fun hasGroupsSizeX(deck: IntArray): Boolean {

        if (deck.size == 0) {
            return false
        }

        var maxSize = Int.MIN_VALUE
        var minSize = Int.MAX_VALUE
        val cards = mutableMapOf<Int, Int>().withDefault({ 0 })
        for (card in deck) {
            val count = cards.getValue(card) + 1
            cards.put(card, count)
        }

        maxSize = maxOf(maxSize, cards.values.max()!!)
        minSize = minOf(minSize, cards.values.min()!!)

        if (maxSize == 1 || minSize == 1) {
            // at least one card is the only one of its kind
            return false
        }

        if (maxSize == minSize) {
            // same number of each card
            return true
        }


        // need to find a common multiple of all values
        var prevGcd = 0
        for (v in cards.values) {
            prevGcd = gcd(prevGcd, v)
        }

        return prevGcd >= 2
    }

    fun gcd(a: Int, b: Int) : Int {
        return if (b==0) {
            a
        } else {
            gcd(b, a%b)
        }
    }
}