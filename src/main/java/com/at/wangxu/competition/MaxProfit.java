package com.at.wangxu.competition;

import java.util.Arrays;

/**
 * 5563. 销售价值减少的颜色球
 * 
 * https://leetcode-cn.com/problems/sell-diminishing-valued-colored-balls/solution/xiao-shou-jie-zhi-jian-shao-de-yan-se-qiu-by-zerot/
 */
public class MaxProfit {
    
    static final int mo = 1000000007;

    public int maxProfit(int[] inventory, int orders) {
        int l = 0;
        int r = Arrays.stream(inventory).max().getAsInt();
        long T = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            long total = 0;
            for (int i : inventory) {
                if (i >= mid) {
                    total += i - mid;
                }
            }

            if (total <= orders) {
                T = mid;
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }
        long rest = 0;
        long t = 0;
        for (int i : inventory) {
            if (i >= T) {
                t += i - T;
            }
        }

        rest = orders - t;

        long ans = 0;

        for (int i : inventory) {
            if (i >= T) {
                if (rest > 0 ) {
                    ans += (long)(T + i) * (i - T + 1) / 2;
                    rest --;
                }else {
                    ans += (long)(T + 1 + i) * (i - (T + 1) + 1) / 2;
                }
            }
        }
        return (int) (ans % mo);
    }

    public static void main(String[] args) {
        MaxProfit maxProfit = new MaxProfit();
        // System.out.println(maxProfit.maxProfit(new int[]{2,5}, 4));
        // System.out.println(maxProfit.maxProfit(new int[]{3,5}, 6));
        // System.out.println(maxProfit.maxProfit(new int[]{2,8,4,10,6}, 20));
        System.out.println(maxProfit.maxProfit(new int[]{1000000000}, 1000000000));
    }
}
