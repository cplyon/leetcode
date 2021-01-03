#!  /usr/bin/env python3

class Node:
    def __init__(self, value: int):
        self.value = value
        self.next = None
        self.prev = None


class LRUCache:

    # Initialize the LRU cache with positive size capacity.
    def __init__(self, capacity: int):
        if capacity <= 0:
            raise Exception()
        self.capacity = capacity
        self.values = {}
        self.usages = None
        self.lru = None
        self.mru = None

    # Return the value of the key if the key exists, otherwise return -1.
    def get(self, key: int) -> int:

        if key in self.values:
            value, node = self.values[key]
            self.mru = node
            return value

        return -1

    # Update the value of the key if the key exists.
    # Otherwise, add the key-value pair to the cache.
    # If the number of keys exceeds the capacity from this operation,
    # evict the least recently used key.
    def put(self, key: int, value: int) -> None:

        new_node = Node(value)

        if key not in self.values:

            if len(self.values) == self.capacity:
                # evict LRU from linked-list and hashtable
                pass

        # insert new item into hashtable and linked-list
        self.values[key] = (value, new_node)

        # update to be mru
        self.mru = new_node


if __name__ == "__main__":
    cache = LRUCache(5)
    cache.put(2, 2)
    print(cache.get(2))
