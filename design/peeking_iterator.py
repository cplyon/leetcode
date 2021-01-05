#! /usr/bin/env python3

# Given an Iterator class interface with methods: next() and hasNext(),
# design and implement a PeekingIterator that support the peek() operation --
# it essentially peek() at the element that will be returned by the next
# call to next().


# Below is the interface for Iterator, which is already defined for you.
class Iterator:
    def __init__(self, nums: list[int]):
        """
        Initializes an iterator object to the beginning of a list.
        """
        self.nums = nums
        self.index = 0

    def hasNext(self) -> bool:
        """
        Returns true if the iteration has more elements.
        """
        return self.index < len(nums)

    def next(self) -> int:
        """
        Returns the next element in the iteration.
        """
        if self.hasNext():
            x = nums[self.index]
            self.index += 1
            return x
        else:
            return None


class PeekingIterator:
    def __init__(self, iterator: Iterator):
        self.iter = iterator
        self.peek_val = None

    def peek(self) -> int:
        """
        Returns the next element in the iteration without advancing the
        iterator.
        """
        if self.peek_val:
            return self.peek_val
        if self.hasNext():
            self.peek_val = self.iter.next()
            return self.peek_val
        else:
            return None

    def next(self) -> int:
        if self.peek_val:
            temp = self.peek_val
            self.peek_val = None
            return temp
        return self.iter.next()

    def hasNext(self) -> bool:
        if self.peek_val:
            return True
        return self.iter.hasNext()


if __name__ == "__main__":
    nums = [1, 2, 3, 4]
    iter = PeekingIterator(Iterator(nums))
    print(iter.hasNext())
    print(iter.peek())
    print(iter.peek())
    print(iter.next())
    print(iter.next())
    print(iter.peek())
    print(iter.peek())
    print(iter.next())
    print(iter.hasNext())
    print(iter.peek())
    print(iter.hasNext())
    print(iter.next())
    print(iter.hasNext())
