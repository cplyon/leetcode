#! /usr/bin/env python3

class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.MOD = 2069
        self.ht = [[] for x in range(self.MOD)]

    def add(self, key: int) -> None:
        values = self.ht[key % self.MOD]
        if key not in values:
            values.append(key)

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        return key in self.ht[key % self.MOD]

    def remove(self, key: int) -> None:
        values = self.ht[key % self.MOD]
        if key in values:
            values.remove(key)

if __name__ == "__main__":
    ht = MyHashSet()
    ht.add(1)
    print(ht.contains(1))
    ht.remove(1)
    print(ht.contains(1))
    ht.remove(1)
