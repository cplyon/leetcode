#! /usr/bin/env python3

class Solution:
    def minMutation(self, start: str, end: str, bank: list[str]) -> int:
        if end not in bank:
            return -1

        combos = {}
        for word in bank:
            for i in range(len(word)):
                wild = word[:i] + "*" + word[i+1:]
                if wild not in combos:
                    combos[wild] = []
                combos[wild].append(word)

        queue = []
        queue.append((start, 1))
        while len(queue) > 0:
            word, count = queue.pop(0)
            for i in range(len(word)):
                wild = word[:i] + "*" + word[i+1:]
                if wild not in combos:
                    continue
                for w in combos[wild]:
                    if w == end:
                        return count
                    queue.append((w, count+1))
                del(combos[wild])

        return -1


if __name__ == "__main__":
    s = Solution()
    start = "AACCGGTT"
    end = "AAACGGTA"
    bank = ["AACCGGTA", "AACCGCTA", "AAACGGTA"]
    print(s.minMutation(start, end, bank))
