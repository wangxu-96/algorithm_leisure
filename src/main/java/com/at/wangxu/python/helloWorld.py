print("Hello world")

import collections
from typing import List
class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        return collections.Counter(s) == collections.Counter(t)

    def maxProfit(self, inventory: List[int], orders: int) -> int:
        mod = 10**9 + 7
        
        # 二分查找 T 值
        l, r, T = 0, max(inventory), -1
        while l <= r:
            mid = (l + r) // 2
            total = sum(ai - mid for ai in inventory if ai >= mid)
            if total <= orders:
                T = mid
                r = mid - 1
            else:
                l = mid + 1

        range_sum = lambda x, y: (x + y) * (y - x + 1) // 2
        
        rest = orders - sum(ai - T for ai in inventory if ai >= T)
        ans = 0
        for ai in inventory:
            if ai >= T:
                if rest > 0:
                    ans += range_sum(T, ai)
                    rest -= 1
                else:
                    ans += range_sum(T + 1, ai)
                    
        return ans % mod

print(Solution.isAnagram(Solution,"anagram","nagaram"))

print(Solution.maxProfit(Solution,[2,8,4,10,6],20))



