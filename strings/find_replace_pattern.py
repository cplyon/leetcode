#! /usr/bin/env python3

class Solution:
    def findAndReplacePattern(self, words: list[str], pattern: str) -> list[str]:
        result = []

        if words and pattern:

            length = len(pattern)
            if length == 1:
                return words

            pattern_counts = {}
            for c in pattern:
                if c not in pattern_counts:
                    pattern_counts[c] = 0
                pattern_counts[c] += 1

            for word in words:
                word_uniques = set(word)
                pattern_uniques = set(pattern)

                word_counts = {}
                for c in word:
                    if c not in word_counts:
                        word_counts[c] = 0
                    word_counts[c] += 1

                match = True
                if len(word_uniques) == len(pattern_uniques):
                    for i in range(length):
                        if word[i] in word_uniques and pattern[i] in pattern_uniques:
                            if word_counts[word[i]] != pattern_counts[pattern[i]]:
                                match = False
                                break
                            word_uniques.remove(word[i])
                            pattern_uniques.remove(pattern[i])
                        elif word[i] not in word_uniques and pattern[i] not in pattern_uniques:
                            pass
                        else:
                            match = False
                            break
                    if match:
                        result.append(word)

        return result


if __name__ == "__main__":
    s = Solution()
    words = ["abc","deq","mee","aqq","dkd","ccc"]
    pattern = "abb"
    print(s.findAndReplacePattern(words, pattern))
