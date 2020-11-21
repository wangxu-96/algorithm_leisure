from typing import List
import random


class Solution:
    def kClosest(self, points: List[List[int]], K: int) -> List[List[int]]:
        def random_select(left: int, right: int, K: int):
            pivot_id = random.randint(left, right)
            pivot = points[pivot_id][0] ** 2 + points[pivot_id][1] ** 2
            points[right], points[pivot_id] = points[pivot_id], points[right]
            i = left - 1
            for j in range(left, right):
                if points[j][0] ** 2 + points[j][1] ** 2 <= pivot:
                    i += 1
                    points[i], points[j] = points[j], points[i]
            i += 1
            points[i], points[right] = points[right], points[i]
            # [left, i-1] 都小于等于 pivot, [i+1, right] 都大于 pivot
            if K < i - left + 1:
                random_select(left, i - 1, K)
            elif K > i - left + 1:
                random_select(i + 1, right, K - (i - left + 1))

        n = len(points)
        random_select(0, n - 1, K)
        return points[:K]
    
    def nextPermutation(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        for i in nums:
            print(i)

print(Solution.kClosest(Solution, [[1, 3], [-2, 2]], 1))
print(Solution.kClosest(Solution, [[3,3],[5,-1],[-2,4]], 2))
print(Solution.nextPermutation(Solution, [1,2,3]))
