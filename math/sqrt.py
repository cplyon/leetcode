#! /usr/local/bin/python3

# Given a non-negative integer x, compute and return the square root of x.

# Since the return type is an integer, the decimal digits are truncated,
# and only the integer part of the result is returned.

class Solution:
    def mySqrt(self, x: int) -> int:
        if x <= 0:
            return 0
        if x == 1:
            return 1

        left = 0
        right = x//2
        mid = 0
        squared = 0
        while (left <= right):
            mid = (left+right)//2
            squared = mid**2
            if squared == x:
                return mid
            if squared < x:
                left = mid + 1
            else:
                right = mid - 1

        if squared > x:
            return mid - 1
        return mid


if __name__ == "__main__":
    s = Solution()
    x = 4
    print(s.mySqrt(x))
