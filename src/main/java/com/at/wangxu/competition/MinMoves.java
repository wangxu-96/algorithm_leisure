package com.at.wangxu.competition;

/**
 * 5615. 使数组互补的最少操作次数
 * https://leetcode-cn.com/problems/minimum-moves-to-make-array-complementary/
 */
public class MinMoves {
    public int minMoves(int[] nums, int limit) {
        int n = nums.length;
        int[] delta = new int[limit * 2 + 2];
        for (int i = 0; i < n / 2; i++) {
            int lo = 1 + Math.min(nums[i], nums[n - i - 1]);
            int hi = limit + Math.max(nums[i], nums[n - i - 1]);
            int sum = nums[i] + nums[n - i - 1];
            delta[lo]--;
            delta[sum]--;
            delta[sum + 1]++;
            delta[hi + 1]++;
        }
        int now = n;
        int ans = n;
        for (int i = 2; i <= limit * 2; ++i) {
            now += delta[i];
            ans = Math.min(ans, now);
        }
        return ans;
    }

    public static void main(String[] args) {
        MinMoves minMoves = new MinMoves();
        // System.out.println(minMoves.minMoves(new int[]{1,2,4,3}, 4));
        // System.out.println(minMoves.minMoves(new int[]{1,2,2,1}, 2));
        // System.out.println(minMoves.minMoves(new int[]{1,2,1,2}, 2));
        System.out.println(minMoves.minMoves(new int[]{37,2,9,49,58,57,48,17}, 58));
    }
}
