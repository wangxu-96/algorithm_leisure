package com.at.wangxu.leetcode;

/**
 * 45. 跳跃游戏 II https://leetcode-cn.com/problems/jump-game-ii/
 */
public class Jump {
    public int jump(int[] nums) {
        int count = 0 ;
        int max = 0;
        int end = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            max = Math.max(max, i + nums[i]);
            if (i == end) {
                end = max;
                count ++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Jump jump = new Jump();
        System.out.println(jump.jump(new int[] { 2, 3, 1, 1, 4 }));
    }
}
