#! /usr/local/bin/python3

class Solution:

    def titleToNumber(self, s: str) -> int:
        offset = ord('A') - 1
        col = 0
        for i in range(len(s)-1, -1, -1):
            col += (ord(s[i])-offset)*(26**(len(s)-1-i))
        return col


if __name__ == "__main__":
    s = Solution()
    input = "A"
    print(s.titleToNumber(input))
