#! /usr/bin/env python3

# class NestedInteger:
#    def isInteger(self) -> bool:
#        """
#       @return true if this NestedInteger holds a single integer, rather than a nested list.
#        """
#
#    def getInteger(self) -> int:
#        """
#        @return the single integer that this NestedInteger holds, if it holds a single integer
#        Return None if this NestedInteger holds a nested list
#        """
#
#    def getList(self) -> [NestedInteger]:
#        """
#        @return the nested list that this NestedInteger holds, if it holds a nested list
#        Return None if this NestedInteger holds a single integer
#        """

class NestedIterator:
    def __init__(self, nestedList: list[NestedInteger]):
        self.i = 0
        self.flatList = self.flatten(nestedList)

    def next(self) -> int:
        val = self.flatList[self.i]
        self.i += 1
        return val

    def hasNext(self) -> bool:
        return self.i < len(self.flatList)

    def flatten(self, nestedList) -> list[int]:
        flatList = []
        for n in nestedList:
            if n.isInteger():
                flatList.append(n.getInteger())
            else:
                flatList.extend(self.flatten(n.getList()))
        return flatList


if __name__ == "__main__":
    flattened = []
    nestedList = [[1, 1], 2, [1, 1]]
    n = NestedIterator(nestedList)
    while n.hasNext():
        flattened.append(n.next())
    print(flattened)
