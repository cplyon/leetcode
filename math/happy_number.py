#! /usr/local/bin/python3

# A happy number is a number defined by the following process:
#    Starting with any positive integer, replace the number by the sum
#       of the squares of its digits.
#    Repeat the process until the number equals 1 (where it will stay),
#       or it loops endlessly in a cycle which does not include 1.
#    Those numbers for which this process ends in 1 are happy.
# 1 <= n <= 2^31 - 1

class Solution:
    def isHappy(self, n: int) -> bool:
        if n < 1:
            return False

        # store intermediate results in a set
        results = set()
        result = n
        while result != 1:
            # get the previous result's digits
            # and sum their squares
            sum = 0
            while result > 0:
                digit = result % 10
                sum += digit**2
                result //= 10

            # if we've seen this result before, n is not happy
            if sum in results:
                return False

            # we haven't seen this before, so continue
            results.add(sum)
            result = sum

        # n is happy
        return True


if __name__ == "__main__":
    s = Solution()
    n = 19
    print(s.isHappy(n))
