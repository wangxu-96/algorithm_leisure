package com.at.wangxu.competition;

import java.util.LinkedList;
import java.util.List;

/**
 * 得到连续 K 个 1 的最少相邻交换次数
 *
 *
 给你一个整数数组 nums 和一个整数 k 。 nums 仅包含 0 和 1 。每一次移动，你可以选择 相邻 两个数字并将它们交换。

 请你返回使 nums 中包含 k 个 连续 1 的 最少 交换次数。

 示例 1：

 输入：nums = [1,0,0,1,0,1], k = 2
 输出：1
 解释：在第一次操作时，nums 可以变成 [1,0,0,0,1,1] 得到连续两个 1 。
 */
public class MinMovesOne {

    public int minMoves(int[] nums, int k) {
        if (k == 1) return 0;
        List<Integer> sum = new LinkedList<>();//v的前缀和
        sum.add(0);
        List<Integer> v = new LinkedList<>();//fi - i
        int n = nums.length;
        int count = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                count ++;
                v.add(i - count);
                sum.add(sum.get(sum.size() - 1) + i - count);
            }
        }
        int ans = Integer.MAX_VALUE;
        int m = v.size();
        for (int i = 0; i <= m - k; i++) {
            int mid = (i + i + k - 1) / 2;
            int q = v.get(mid);
            ans = Math.min((2 * (mid - i) - k + 1) * q + (sum.get(i + k) - sum.get(mid + 1) - (sum.get(mid) - sum.get(i))), ans);
        }
        return ans;
    }


    public static void main(String[] args) {
        MinMovesOne bean = new MinMovesOne();
        System.out.println(bean.minMoves(new int[]{1, 0, 0, 0, 0, 0, 1, 1}, 3));
        System.out.println(bean.minMoves(new int[]{1, 0, 0, 1, 0, 1}, 2));
        System.out.println(bean.minMoves(new int[]{1, 1, 0, 1}, 2));
        System.out.println(bean.minMoves(new int[]{1, 0, 0, 1, 0, 1, 1, 1, 0, 1, 1}, 7));
    }
}
