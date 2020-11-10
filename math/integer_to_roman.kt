fun main() {
    val s = Solution()
    val num = 3999
    println(s.intToRoman(num))
}


class Solution {
    fun intToRoman(num: Int): String {
        // 1 <= num <= 3999

        var result = StringBuilder()

        val thousands = num / 1000
        var hundreds = (num - thousands * 1000) / 100
        var tens = (num - thousands * 1000 - hundreds * 100) / 10
        var ones = num % 10

        for (i in 1..thousands) {
            result.append("M")
        }

        if (hundreds == 9) {
            result.append("CM")
        } else if (hundreds == 4) {
            result.append("CD")
        } else {
            if (hundreds >= 5) {
                result.append("D")
                hundreds -= 5
            }
            for (i in 1..hundreds) {
                result.append("C")
            }
        }

        if (tens == 9) {
            result.append("XC")
        } else if (tens == 4) {
            result.append("XL")
        } else {
            if (tens >= 5) {
                result.append("L")
                tens -= 5
            }
            for (i in 1..tens) {
                result.append("X")
            }
        }

        if (ones == 9) {
            result.append("IX")
        } else if (ones == 4) {
            result.append("IV")
        } else {
            if (ones >= 5) {
                result.append("V")
                ones -= 5
            }
            for (i in 1..ones) {
                result.append("I")
            }
        }

        return result.toString()
    }

}