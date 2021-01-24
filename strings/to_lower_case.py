#! /usr/bin/env python3

# Implement function ToLowerCase() that has a string parameter str,
# and returns the same string in lowercase.

class Solution:
    def toLowerCase(self, str: str) -> str:
        if not str:
            return str
        result = ""
        for c in str:
            ordinal = ord(c)
            if 64 < ordinal < 97:
                result += chr(ordinal+32)
            else:
                result += c
        return result


if __name__ == "__main__":
    s = Solution()
    str = "HeLLo123"
    print(s.toLowerCase(str))
