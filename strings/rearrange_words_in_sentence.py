#! /usr/bin/env python3

# Given a sentence text (A sentence is a string of space-separated words
# in the following format:
#    First letter is in upper case.
#    Each word in text are separated by a single space.

# Your task is to rearrange the words in text such that all words are
# rearranged in an increasing order of their lengths. If two words have
# the same length, arrange them in their original order.

# Return the new text following the format shown above.

class Solution:
    def arrangeWords(self, text: str) -> str:
        if not text:
            return ""
        words = text.split(" ")
        words[0] = words[0].lower()
        words.sort(key=lambda w: len(w))
        words[0] = words[0][0].upper() + words[0][1:]

        return " ".join(words)


if __name__ == "__main__":
    solution = Solution()
    text = "Hello world"
    print(solution.arrangeWords(text))
