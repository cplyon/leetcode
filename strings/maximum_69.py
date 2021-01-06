#! /usr/bin/env python3

class Solution:

    def maximum69Number(self, num: int) -> int:
        return int(str(num).replace("6", "9", 1))

    def maximum69Number2(self, num: int) -> int:
        s = str(num)
        r = ""
        i = 0
        for i in range(len(s)):
            if s[i] == "6":
                r += "9"
                break
            r += s[i]
        return int(r + s[i+1:])


if __name__ == "__main__":
    s = Solution()
    num = 6969
    print(s.maximum69Number(num))
    print(s.maximum69Number2(num))
