#! /usr/bin/env python3

class Solution:
    def reverseWords(self, s: str) -> str:
        if not s or len(s) <= 1:
            return s

        # reverse s and split on spaces
        words = s[::-1].split(' ')
        # reassemble sentence with all non-zero length words
        return ' '.join([w[::-1] for w in words if w])


if __name__ == "__main__":
    s = Solution()
    string = "  Bob    Loves  Alice   "
    print(s.reverseWords(string))
