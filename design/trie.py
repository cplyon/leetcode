#! /usr/bin/env python3

class TrieNode:
    def __init__(self, letter: str):
        self.letter = letter
        self.end_of_word = False
        self.letters = {}


class Trie:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = TrieNode(None)

    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        cur = self.root
        for c in word:
            if c not in cur.letters:
                cur.letters[c] = TrieNode(c)
            cur = cur.letters[c]
        cur.end_of_word = True

    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        cur = self.search_helper(word)
        return cur is not None and cur.end_of_word

    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        cur = self.search_helper(prefix)
        return cur is not None

    def search_helper(self, word: str) -> TrieNode:
        cur = self.root
        for c in word:
            if c not in cur.letters:
                return None
            cur = cur.letters[c]
        return cur


if __name__ == "__main__":
    trie = Trie()
    trie.insert("apple")
    print(trie.search("apple"))   # returns true
    print(trie.search("app"))    # returns false
    print(trie.startsWith("app")) # returns true
    trie.insert("app")
    print(trie.search("app")) # returns true
