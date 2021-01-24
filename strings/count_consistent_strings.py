#! /usr/bin/env python3

# You are given a string allowed consisting of distinct characters and
# an array of strings words. A string is consistent if all characters in
# the string appear in the string allowed.
# Return the number of consistent strings in the array words.

class Solution:
    def countConsistentStrings(self, allowed: str, words: list[str]) -> int:
        if not allowed or not words:
            return 0
        letters = set([c for c in allowed])
        count = len(words)
        for word in words:
            for c in word:
                if c not in letters:
                    count -= 1
                    break
        return count


if __name__ == "__main__":
    s = Solution()
    allowed = "ab"
    words = ["ad", "bd", "aaab", "baa", "badab"]
    print(s.countConsistentStrings(allowed, words))
