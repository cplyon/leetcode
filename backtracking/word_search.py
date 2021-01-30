#! /usr/bin/env python3

class Solution:

    def exist(self, board: list[list[str]], word: str) -> bool:
        if not word or not board or len(board[0]) == 0:
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

        visited = set()
        for i in range(len(board)):
            for j in range(len(board[0])):
                if dfs(i, j, word):
                    return True

        return False








if __name__ == "__main__":
    s = Solution()
    #board = [["A","B","C","E"],
    #         ["S","F","C","S"],
    #         ["A","D","E","E"]]

    board = [["b","a","b","b","b","b","c","c"],
             ["a","c","a","c","b","a","b","c"],
             ["b","c","c","c","a","a","b","b"],
             ["b","a","c","c","a","a","c","c"],
             ["a","a","a","b","c","a","c","c"],
             ["a","a","c","c","b","b","c","a"],
             ["a","b","a","a","c","c","a","c"],
             ["a","c","b","b","c","c","a","a"],
             ["c","b","b","c","c","b","a","a"],
             ["c","c","a","b","c","c","b","a"],
             ["b","c","b","c","c","c","b","a"],
             ["b","a","c","a","c","a","a","a"],
             ["c","c","c","c","c","c","a","b"]]

    #word = "ABCCED"
    word = "accbcaabbccabc"
    print(s.exist(board, word))
