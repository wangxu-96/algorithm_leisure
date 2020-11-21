package com.at.wangxu.leetcode;

import java.util.Arrays;

public class SortArrayByParityII {

    //循环偶数位 如果当前位置是奇数 寻找奇数位上的偶数 二者交换
    public int[] sortArrayByParityII(int[] A) {
        int odd = 1;
        for (int i = 0; i < A.length; i += 2) {
            if ( (A[i] & 1) == 1) {
                while ((A[odd]& 1) == 1) {
                    odd += 2;
                }
                swap(A, i, odd);
            }
        }
        return A;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        SortArrayByParityII sortArrayByParityII = new SortArrayByParityII();
        Arrays.stream(sortArrayByParityII.sortArrayByParityII(new int[] { 3,1,4,2 })).forEach(System.out::println);;
    }
}
