package com.at.wangxu.competition;

import java.util.Arrays;

/**
 * 5559. 得到山形数组的最少删除次数
 */
public class MinimumMountainRemovals {
    
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        int[] f = new int[n];
        int[] g = new int[n];
        Arrays.fill(f, 1);
        Arrays.fill(g, 1);
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[j] < nums[i]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
        }
        for (int i = n - 1; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                if (nums[j] < nums[i]) {
                    g[i] = Math.max(g[i], g[j] + 1);
                }
            }
        }
        int ans = n;
        for (int i = 0; i < n; ++i) {
            if (f[i] > 1 && g[i] > 1) {
                ans = Math.min(ans, n - (f[i] + g[i] - 1));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MinimumMountainRemovals min = new MinimumMountainRemovals();
        System.out.println(min.minimumMountainRemovals(new int[]{1,3,1}));
        System.out.println(min.minimumMountainRemovals(new int[]{2,1,1,5,6,2,3,1}));
        System.out.println(min.minimumMountainRemovals(new int[]{4,3,2,1,1,2,3,1}));
        System.out.println(min.minimumMountainRemovals(new int[]{1,2,3,4,4,3,2,1}));
        System.out.println(min.minimumMountainRemovals(new int[]{1,16,84,9,29,71,86,79,72,12}));
    }
}
