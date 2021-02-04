#! /usr/bin/env python3

class Solution:
    def pancakeSort(self, arr: list[int]):
        if not arr or len(arr) < 2:
            return arr

        def flip(arr, k):
            if 1 >= k > len(arr):
                return arr
            if not arr:
                return arr

            temp = arr[:k]
            temp.reverse()
            arr[:k] = temp

        max_val = len(arr)
        result = []
        expected = sorted(arr)
        while arr != expected:
            for i, n in enumerate(arr):
                if n == max_val:
                    flip(arr, i+1)
                    result.append(i+1)
                    flip(arr, max_val)
                    result.append(max_val)
                    max_val -= 1

        return result



if __name__ == "__main__":
    s = Solution()
    arr = [3,2,4,1]
    print(s.pancakeSort(arr))
