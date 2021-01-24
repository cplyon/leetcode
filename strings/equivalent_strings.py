#! /usr/bin/env python3

# Given two string arrays word1 and word2,
# return true if the two arrays represent the same string,
# and false otherwise.

# A string is represented by an array if the array elements
# concatenated in order forms the string.

class Solution:
    def arrayStringsAreEqual(self, word1: list[str], word2: list[str]) -> bool:
        return "".join(word1) == "".join(word2)


if __name__ == "__main__":
    s = Solution()
    word1 = ["ab", "c"]
    word2 = ["a", "bc"]
    print(s.arrayStringsAreEqual(word1, word2))

