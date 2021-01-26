#! /usr/bin/env python3

from random import randint


class RandomizedSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.ht = {}
        self.random_access = []

    def insert(self, val: int) -> bool:
        """
        Inserts a value to the set. Returns true if the set did not already
        contain the specified element.
        """
        if val in self.ht:
            return False

        index = len(self.random_access)
        self.random_access.append(val)
        self.ht[val] = index

        return True

    def remove(self, val: int) -> bool:
        """
        Removes a value from the set. Returns true if the set contained the
        specified element.
        """
        if val not in self.ht:
            return False

        index = self.ht[val]
        self.random_access[index] = self.random_access[-1]

        if index < len(self.random_access):
            self.ht[self.random_access[index]] = index

        del(self.ht[val])
        self.random_access.pop()
        return True

    def getRandom(self) -> int:
        """
        Get a random element from the set.
        """
        return self.random_access[randint(0, len(self.random_access)-1)]


if __name__ == "__main__":
    rs = RandomizedSet()
    print(rs.insert(0))  # true
    print(rs.insert(1))  # true
    print(rs.remove(0))  # true
    print(rs.insert(2))  # true
    print(rs.remove(1))  # true
