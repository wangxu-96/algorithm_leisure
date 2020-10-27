package com.at.wangxu.geektime.week1;

/**
 * 42. 接雨水
 * 
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 输入：height =
 * [0,1,0,2,1,0,1,3,2,1,2,1] 输出：6 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1]
 * 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 示例 2：
 * 
 * 输入：height = [4,2,0,3,2,5] 输出：9  
 * 
 * 提示：
 * 
 * n == height.length 0 <= n <= 3 * 104 0 <= height[i] <= 105
 */
public class Trap {
    // 当前位置能储存的水 = min(他左边的最高者 - 他右边的最高者) - height[i]
    public int trap(int[] height) {
        int ans = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int max_left = 0;
            int max_right = 0;
            for (int j = i; j >= 0; j--) {
                max_left = Math.max(max_left, height[j]);
            }

            for (int j = i; j < height.length; j++) {
                max_right = Math.max(max_right, height[j]);
            }
            ans += Math.min(max_left, max_right) - height[i];
        }
        return ans;
    }

    public int trap1(int[] height) {
        if (height == null || height.length == 0)
            return 0;
        int ans = 0;
        int[] left_max = new int[height.length];
        int[] right_max = new int[height.length];

        left_max[0] = height[0];
        for (int i = 1; i < right_max.length; i++) {
            left_max[i] = Math.max(height[i], left_max[i - 1]);
        }

        right_max[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            right_max[i] = Math.max(height[i], right_max[i + 1]);
        }

        for (int i = 1; i < height.length - 1; i++) {
            ans += Math.min(left_max[i], right_max[i]) - height[i];
        }

        return ans;
    }

    public int trap2(int[] height) {
        int ans = 0;

        int left_max = 0;
        int right_max = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            if (height[left] < height[right]) {
                if (left_max <= height[left]) {
                    left_max = height[left];
                } else {
                    ans += left_max - height[left];
                }
                left++;
            } else {
                if (right_max <= height[right]) {
                    right_max = height[right];
                } else {
                    ans += right_max - height[right];
                }
                right--;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Trap trap = new Trap();
        System.out.println(trap.trap(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }));
        System.out.println(trap.trap(new int[] { 4, 2, 0, 3, 2, 5 }));
        System.out.println(trap.trap1(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }));
        System.out.println(trap.trap1(new int[] { 4, 2, 0, 3, 2, 5 }));
        System.out.println(trap.trap2(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }));
        System.out.println(trap.trap2(new int[] { 4, 2, 0, 3, 2, 5 }));
    }

}
