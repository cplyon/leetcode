#! /usr/bin/env python3

class Solution:
    def gameOfLife(self, board: list[list[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        if not board or not board[0]:
            return

        DEAD = 0
        ALIVE = 1
        WAS_DEAD = 2
        WAS_ALIVE = 3

        for i in range(len(board)):
            for j in range(len(board[0])):
                num_live_neighbours = 0
                if i > 0:
                    if j > 0:
                        if board[i-1][j-1] == ALIVE or board[i-1][j-1] == WAS_ALIVE:
                            num_live_neighbours += 1
                    if board[i-1][j] == ALIVE or board[i-1][j] == WAS_ALIVE:
                        num_live_neighbours += 1
                    if j < len(board[0])-1:
                        if board[i-1][j+1] == ALIVE or board[i-1][j+1] == WAS_ALIVE:
                            num_live_neighbours += 1

                if j > 0:
                    if board[i][j-1] == ALIVE or board[i][j-1] == WAS_ALIVE:
                        num_live_neighbours += 1
                if j < len(board[0])-1:
                    if board[i][j+1] == ALIVE or board[i][j+1] == WAS_ALIVE:
                        num_live_neighbours += 1

                if i < len(board)-1:
                    if j > 0:
                        if board[i+1][j-1] == ALIVE or board[i+1][j-1] == WAS_ALIVE:
                            num_live_neighbours += 1
                    if board[i+1][j] == ALIVE or board[i+1][j] == WAS_ALIVE:
                        num_live_neighbours += 1
                    if j < len(board[0])-1:
                        if board[i+1][j+1] == ALIVE or board[i+1][j+1] == WAS_ALIVE:
                            num_live_neighbours += 1

                if board[i][j] == ALIVE:
                    if num_live_neighbours < 2:
                        board[i][j] = WAS_ALIVE
                    elif num_live_neighbours > 3:
                        board[i][j] = WAS_ALIVE
                elif board[i][j] == DEAD:
                    if num_live_neighbours == 3:
                        board[i][j] = WAS_DEAD

        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j] == WAS_ALIVE:
                    board[i][j] = DEAD
                elif board[i][j] == WAS_DEAD:
                    board[i][j] = ALIVE



if __name__ == "__main__":
    s = Solution()
    board = [
        [0, 1, 0],
        [0, 0, 1],
        [1, 1, 1],
        [0, 0, 0]
        ]

    print(board)
    s.gameOfLife(board)
    print(board)
