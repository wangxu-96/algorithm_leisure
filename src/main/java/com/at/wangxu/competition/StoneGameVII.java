package com.at.wangxu.competition;

import java.util.Arrays;

/**
 * 5627. 石子游戏 VII
 */
public class StoneGameVII {
    int[] sum;
    //[l,r] sum
    private int get(int l,int r) {
        return sum[r + 1] - sum[l];
    }
    public int stoneGameVII(int[] stones) {
        sum = new int[stones.length + 1];
        for (int i = 0; i < stones.length; i++) {
            sum[i + 1] = sum[i] + stones[i];
        }
        dp = new int[stones.length][stones.length];
        for (int[] ints : dp) {
            Arrays.fill(ints, -1);
        }
        return dp(0, stones.length -1 );
    }
    int[][] dp ;
    private int dp(int l,int r) {
        if (l == r) return 0;
        dp[l][r] = Math.max(get(l + 1, r) - dp[l + 1][r] != -1 ? dp[l + 1][r] : dp(l + 1, r),
                get(l, r - 1) - dp[l][r - 1] != -1 ? dp[l][r - 1]: dp(l, r - 1));
        return dp[l][r];
    }

    public static void main(String[] args) {
        StoneGameVII gameVII = new StoneGameVII();
        System.out.println(gameVII.stoneGameVII(new int[]{5,3,1,4,2}));
        System.out.println(gameVII.stoneGameVII(new int[]{7,90,5,1,100,10,10,2}));
    }
}
