#! /usr/bin/env python3

class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: list[str]) -> int:
        if not beginWord or not endWord or len(beginWord) != len(endWord) or not wordList or endWord not in wordList:
            return 0

        map = {}
        WILDCARD = "*"
        for word in wordList:
            for i in range(len(word)):
                wild_word = word[:i] + WILDCARD + word[i+1:]
                if wild_word not in map:
                    map[wild_word] = []
                map[wild_word].append(word)

        visited = set()
        queue = []
        queue.append((beginWord, 2))
        while len(queue) > 0:
            word, count = queue.pop(0)
            for i in range(len(word)):
                wild_word = word[:i] + WILDCARD + word[i+1:]
                if wild_word in visited:
                    continue
                visited.add(wild_word)
                if wild_word in map:
                    for w in map[wild_word]:
                        if w == endWord:
                            return count
                        queue.append((w, count+1))
                    del(map[wild_word])

        return 0



if __name__ == "__main__":
    s = Solution()
    beginWord = "hit"
    endWord = "cog"
    wordList = ["hot","dot","dog","lot","log","cog"]
    print(s.ladderLength(beginWord, endWord, wordList))
