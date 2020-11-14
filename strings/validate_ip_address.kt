fun main() {
    val s = Solution()
    val IP = "FFFF:db8:85a3:0:0:8A2E:0370:7334"
    println(s.validIPAddress(IP))
}

class Solution {
    fun validIPAddress(IP: String): String {
        if (validateIPv4(IP)) {
            return "IPv4"
        }

        if (validateIPv6(IP)) {
            return "IPv6"
        }

        return "Neither"
    }

    fun validateIPv4(IP: String): Boolean {
        val numbers = IP.split('.')
        // check number of sections separated by periods is correct
        if (numbers.size != 4) {
            return false
        }
        for (n in numbers) {
            // check for leading zeros
            if (n.length > 1 && n[0] == '0') {
                return false
            }
            var intValue : Int
            try {
                intValue = n.toInt()
            } catch (e: Exception) {
                // not a number
                return false
            }
            // check if number is in range
            if (intValue < 0 || intValue > 255) {
                return false
            }
        }
        return true
    }

    fun validateIPv6(IP: String): Boolean {
        val numbers = IP.split(':')
        // check number of sections separated by colons is correct
        if (numbers.size != 8) {
            return false
        }
        for (n in numbers) {
            var intValue : Int
            try {
                intValue = Integer.parseInt(n, 16)
            } catch (e: Exception) {
                // not a number
                return false
            }
            // check if number is in range
            if (intValue < 0 || intValue > 65535) {
                return false
            }
        }

        return true
    }
}

