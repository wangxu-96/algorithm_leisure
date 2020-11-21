package com.at.wangxu.leetcode;

/**
 * https://leetcode-cn.com/problems/valid-mountain-array/ 941. 有效的山脉数组
 * 
 * 给定一个整数数组 A，如果它是有效的山脉数组就返回 true，否则返回 false。
 * 
 * 让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组：
 * 
 * A.length >= 3 在 0 < i < A.length - 1 条件下，存在 i 使得： A[0] < A[1] < ... A[i-1] <
 * A[i] A[i] > A[i+1] > ... > A[A.length - 1]
 */
public class ValidMountainArray {

    public boolean validMountainArray(int[] A) {

        if (A.length < 3)
            return false;
        
        int max = -1;
        for (int i = 1; i < A.length; i++) {
            if (A[i - 1] == A[i]) return false;
            if (max == -1 ) {
                if (A[i - 1] > A[i] ) max = i - 1;
            }else {
                if (A[i - 1] <= A[i]) return false;
            }
        }
        
        return max != -1 && max != 0 ;
    }

    public static void main(String[] args) {
        ValidMountainArray valid = new ValidMountainArray();
        System.out.println(valid.validMountainArray(new int[] { 0, 2, 3,3,5,2,1,0 }));
        System.out.println(valid.validMountainArray(new int[] { 9,8,7,6,5,4,3,2,1,0 }));
    }
}
