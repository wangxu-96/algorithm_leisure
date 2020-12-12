package com.at.wangxu.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 454. 四数相加 II https://leetcode-cn.com/problems/4sum-ii/
 */
public class FourSumCount {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> countAB = new HashMap<Integer, Integer>();
        for (int u : A) {
            for (int v : B) {
                countAB.put(u + v, countAB.getOrDefault(u + v, 0) + 1);
            }
        }
        int ans = 0;
        for (int u : C) {
            for (int v : D) {
                if (countAB.containsKey(-u - v)) {
                    ans += countAB.get(-u - v);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        FourSumCount fourSumCount = new FourSumCount();
        System.out.println(fourSumCount.fourSumCount(new int[] { 1, 2 }, new int[] { -2, -1 }, new int[] { -1, 2 },
                new int[] { 0, 2 }));
    }
}
