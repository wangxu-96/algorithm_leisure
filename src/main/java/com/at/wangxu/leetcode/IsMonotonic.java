package com.at.wangxu.leetcode;

public class IsMonotonic {

    public boolean isMonotonic(int[] A) {
        boolean flag = true;
        for(int i = 1; i < A.length; ++i) {
            if(A[i] <= A[i - 1]) continue;
            flag = false;
        }

        if (flag) return true;

        for(int i = 1; i < A.length; ++i) {
            if(A[i] >= A[i - 1]) continue;
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        IsMonotonic isMonotonic = new IsMonotonic();
        System.out.println(isMonotonic.isMonotonic(new int[]{1,2,2,3}));
        System.out.println(isMonotonic.isMonotonic(new int[]{6,5,4,4}));
        System.out.println(isMonotonic.isMonotonic(new int[]{1,3,2}));
        System.out.println(isMonotonic.isMonotonic(new int[]{1,2,4,5}));
        System.out.println(isMonotonic.isMonotonic(new int[]{1,1,1}));
    }
}
