#! /usr/bin/env python3

class Solution:

    def findWords(self, board: list[list[str]], words: list[str]) -> list[str]:
        if not words or not board or len(board[0]) == 0:
            return False

        def dfs(x: int, y: int, word: str) -> bool:
            if x < 0 or y < 0 or x >= len(board) or y >= len(board[0]):
                return False

            if board[x][y] != word[0]:
                visited.discard((x, y))
                return False

            if (x, y) in visited:
                return False

            if len(word) == 1:
                return True

            visited.add((x, y))
            if dfs(x+1, y, word[1:]) or dfs(x, y+1, word[1:]) or \
               dfs(x-1, y, word[1:]) or dfs(x, y-1, word[1:]):
                return True

            visited.discard((x, y))
            return False

        result = set()
        for word in words:
            visited = set()
            for i in range(len(board)):
                for j in range(len(board[0])):
                    if dfs(i, j, word):
                        result.add(word)

        return list(result)


if __name__ == "__main__":
    s = Solution()
    board = [["o","a","b","n"],["o","t","a","e"],["a","h","k","r"],["a","f","l","v"]]
    words = ["oa","oaa"]
    print(s.findWords(board, words))
