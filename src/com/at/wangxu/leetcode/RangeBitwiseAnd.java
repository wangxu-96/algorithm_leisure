package com.at.wangxu.leetcode;

/**
 * 201. 数字范围按位与
 *
 * 给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，返回此范围内所有数字的按位与（包含 m, n 两端点）。
 *
 * 示例 1: 
 *
 * 输入: [5,7]
 * 输出: 4
 * 示例 2:
 *
 * 输入: [0,1]
 * 输出: 0
 *
 *
 */
public class RangeBitwiseAnd {

    public int rangeBitwiseAnd(int m, int n) {
        int result = m;
        for (int i = m + 1; i <= n; i++) {
            result = i &  result;
        }
        return result;
    }

    /**
     * 给定两个整数，我们要找到它们对应的二进制字符串的公共前缀
     * @param m m
     * @param n n
     * @return 公共前缀
     */
    public int rangeBitwiseAndOfficial(int m, int n) {
        int shift = 0;
        // 找到公共前缀
        while (m < n) {
            m >>= 1;
            n >>= 1;
            ++shift;
        }
        return m << shift;
    }


    public static void main(String[] args) {
//        System.out.println(new RangeBitwiseAnd().rangeBitwiseAnd(5, 7));
//        System.out.println(new RangeBitwiseAnd().rangeBitwiseAnd(0, 1));
//        System.out.println(new RangeBitwiseAnd().rangeBitwiseAnd(1, 2));
//        System.out.println(new RangeBitwiseAnd().rangeBitwiseAnd(0, 2147483647));
        System.out.println(new RangeBitwiseAnd().rangeBitwiseAndOfficial(5, 7));
        System.out.println(new RangeBitwiseAnd().rangeBitwiseAndOfficial(0, 1));
        System.out.println(new RangeBitwiseAnd().rangeBitwiseAndOfficial(1, 2));
        System.out.println(new RangeBitwiseAnd().rangeBitwiseAndOfficial(1, 2147483647));
    }
}
