#! /usr/bin/env python3

class Solution:
    def wordPattern(self, pattern: str, s: str) -> bool:
        # O(n) time, O(n) space
        if not pattern or not s:
            return False

        words = s.split()
        if len(pattern) != len(words):
            return False

        mapping = {}
        mapped = set()
        for i in range(len(pattern)):
            if pattern[i] in mapping:
                if mapping[pattern[i]] != words[i]:
                    return False
            else:
                if words[i] in mapped:
                    return False
                mapping[pattern[i]] = words[i]
                mapped.add(words[i])

        return True


if __name__ == "__main__":
    s = Solution()
    pattern = "abba"
    st = "dog cat cat dog"
    print(s.wordPattern(pattern, st))
