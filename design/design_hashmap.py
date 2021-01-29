#! /usr/bin/env python3

class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.MOD = 2069
        self.ht = [[] for x in range(self.MOD)]


    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        index = key % self.MOD
        values = self.ht[index]
        for i, v in enumerate(values):
            if key == v[0]:
                values[i] = (key, value)
                break
        else:
            values.append((key, value))


    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        index = key % self.MOD
        values = self.ht[index]
        for v in values:
            if v[0] == key:
                return v[1]

        return -1

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        index = key % self.MOD
        values = self.ht[index]
        for i, v in enumerate(values):
            if v[0] == key:
                del(values[i])
                break


if __name__ == "__main__":
    ht = MyHashMap()
    ht.put(1, 1)
