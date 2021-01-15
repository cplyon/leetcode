#! /usr/bin/env python3

class Solution:

    def reachingPoints_modulo(self, sx: int, sy: int, tx: int, ty: int) -> bool:
        while sx < tx and sy < ty:
            tx, ty = tx % ty, ty % tx
        return sx == tx and sy <= ty and (ty - sy) % sx == 0 or \
            sy == ty and sx <= tx and (tx - sx) % sy == 0


    def reachingPoints_backwards(self, sx: int, sy: int, tx: int, ty: int) -> bool:
        x = tx
        y = ty
        while x >= sx and y >= sy:
            if x == sx and y == sy:
                return True
            if x == y:
                return False
            if y > x:
                y -= x
            elif x > y:
                x -= y
        return False


    def reachingPoints_bfs(self, sx: int, sy: int, tx: int, ty: int) -> bool:
        if sx < 1 or sy < 1 or tx < 1 or ty < 1:
            return False

        queue = []
        queue.append((sx, sy))
        while len(queue) > 0:
            cell = queue.pop(0)
            if cell[0] == tx and cell[1] == ty:
                return True
            if cell[0]+cell[1] <= tx:
                queue.append((cell[0]+cell[1], cell[1]))
            if cell[0]+cell[1] <= ty:
                queue.append((cell[0], cell[1]+cell[0]))
        return False

    def reachingPoints_dfs(self, sx: int, sy: int, tx: int, ty: int) -> bool:
        if sx == tx and sy == ty:
            return True
        if sx > tx or sy > ty:
            return False
        return self.reachingPoints_dfs(sx+sy, sy, tx, ty) or \
            self.reachingPoints_dfs(sx, sx+sy, tx, ty)


if __name__ == "__main__":
    s = Solution()
    sx = 1
    sy = 1
    tx = 7
    ty = 9
    print(s.reachingPoints_dfs(sx,sy,tx,ty))
    print(s.reachingPoints_bfs(sx,sy,tx,ty))
    print(s.reachingPoints_backwards(sx,sy,tx,ty))
    print(s.reachingPoints_modulo(sx,sy,tx,ty))
