#! /usr/bin/env python3

class Node:
    def __init__(self, key: str, item: int):
        self.key = key
        self.item = item
        self.next = None
        self.prev = None

    def __str__(self) -> str:
        return str(self.item)


class LRUCache:

    def __init__(self, capacity: int):
        self.capacity = capacity
        self.dictionary = {}
        self.lru: Node = None
        self.mru: Node = None

    def get(self, key: int) -> int:
        if key not in self.dictionary:
            return -1

        node = self.dictionary[key]
        if node.prev:
            node.prev.next = node.next
        if node.next:
            node.next.prev = node.prev
        node.prev = self.mru
        if self.lru.next:
            self.lru = self.lru.next
        self.mru = node

        return node.item

    def put(self, key: int, value: int) -> None:
        if key in self.dictionary:
            node = self.dictionary[key]
            node.item = value
        else:
            # bump out the LRU (from dict and list, update LRU to next)
            if self.lru:
                del(self.dictionary[self.lru.key])
                if self.lru.next:
                    self.lru = self.lru.next
                self.lru.prev = None
            node = Node(key, value)
            self.dictionary[key] = node
        if self.lru:
            if self.lru == node and self.lru.next:
                self.lru = self.lru.next
            self.mru.next = node
            node.prev = self.mru
        else:
            # first item added
            self.lru = node
        # set this node to be the new mru
        self.mru = node


if __name__ == "__main__":
    cache = LRUCache(2)

    print(cache.put(1, 1))
    #print(len(cache.dictionary))
    print(cache.put(2, 2))
    #print(len(cache.dictionary))
    #print(cache.mru.item, cache.lru.item)
    print(cache.get(1))
    print(cache.put(3, 3))
    print("size:", len(cache.dictionary))
    print(cache.get(2))
    print("size:", len(cache.dictionary))
    print(cache.put(4, 4))
    print("size:", len(cache.dictionary))
    #print("mru, lru")
    #print(cache.mru.item, cache.lru.item)
    #print("values start:")
    ##for v in cache.dictionary:
     #   print(v)
    #print("values end:")
    print(cache.get(1))  # bug
    print(cache.get(3))
    print(cache.get(4))
