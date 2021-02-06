package com.at.wangxu.leetcode;

/**
 * 376. 摆动序列
 */
public class WiggleMaxLength {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        boolean f = false;//true > 0,false < 0
        int init = -1;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                dp[0] = 1;
            }else if(i == 1) {
                if (nums[i] == nums[i - 1]) {
                    dp[i] = dp[i - 1];
                    continue;
                }
                dp[1] = 2;
                f = nums[1] > nums[0];
                init = i;
            }else {
                if (nums[i] == nums[i - 1]) {
                    dp[i] = dp[i - 1];
                    continue;
                }
                if (init == -1) {
                    dp[i] = dp[i - 1] + 1;
                    f = nums[i] > nums[i - 1];
                    init = i;
                    continue;
                }
                if (f) {
                    if (nums[i] > nums[i - 1]) {
                        dp[i] = dp[i - 1];
                    }else {
                        dp[i] = dp[i - 1] + 1;
                        f = false;
                    }
                }else {
                    if (nums[i] > nums[i - 1]) {
                        dp[i] = dp[i - 1] + 1;
                        f = true;
                    }else {
                        dp[i] = dp[i - 1];
                    }
                }
            }
        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        WiggleMaxLength maxLength = new WiggleMaxLength();
        System.out.println(maxLength.wiggleMaxLength(new int[]{102,101,20,91,156,78,75,142,69,81,46,142,113,163,190,178,13,102,101,20,91,156,78,75,142,69,81,46,142,113,163,190,178,13,36,134,54,134,54}));
    }
}
