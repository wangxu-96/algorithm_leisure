package com.at.wangxu.leetcode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 321. 拼接最大数 https://leetcode-cn.com/problems/create-maximum-number/
 */
public class MaxNumber {

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int min = Math.min(nums1.length, nums2.length);
        min = Math.min(min, k);
        int max = Math.max(nums1.length, nums2.length);
        boolean bool = nums1.length < nums2.length;
        int[] result = new int[k];
        for (int i = k > max ? k - max : 0; i <= min; i++) {
            int[] a;
            if (bool) {
                a = merge(getMin(nums1, i), getMin(nums2, k - i));
            } else {
                a = merge(getMin(nums2, i), getMin(nums1, k - i));
            }
            if (isLarge(a, result)) {
                result = a;
            }
        }
        return result;
    }

    public int[] getMin(int[] num, int k) {
        Deque<Integer> stack = new LinkedList<>();
        // stack.push(-1);
        for (int i = 0; i < num.length; i++) {
            while (!stack.isEmpty() && num[i] > stack.peek() && k - stack.size() < num.length - i) {
                stack.pop();
            }
            if (stack.size() < k) {
                stack.push(num[i]);
            }
        }
        int[] a = new int[stack.size()];
        int index = a.length - 1;
        while (!stack.isEmpty()) {
            a[index--] = stack.pop();
        }
        return a;
    }

    // nums1 isLarge nums2
    public boolean isLarge(int[] nums1, int[] nums2) {
        int index = 0;
        while (index < nums1.length) {
            if (nums1[index] > nums2[index])
                return true;
            else if (nums1[index] < nums2[index])
                return false;
            index++;
        }
        return false;
    }

    // merge two array
    public int[] merge(int[] nums1, int[] nums2) {
        int[] merged = new int[nums1.length + nums2.length];
        int index1 = 0;
        int index2 = 0;
        int count = 0;
        while (index1 < nums1.length && index2 < nums2.length) {
            if (nums1[index1] > nums2[index2]) {
                merged[count] = nums1[index1++];
            } else if (nums1[index1] < nums2[index2]) {
                merged[count] = nums2[index2++];
            } else {
                // 相同值需要判断选取哪个
                int temp1 = index1 + 1;
                int temp2 = index2 + 1;
                while (temp1 < nums1.length && temp2 < nums2.length) {
                    if (nums1[temp1] < nums2[temp2]) {
                        merged[count] = nums2[index2++];
                        break;
                    } else if (nums1[temp1] > nums2[temp2]) {
                        merged[count] = nums1[index1++];
                        break;
                    }
                    temp1++;
                    temp2++;
                }

                if (temp1 == nums1.length && temp2 == nums2.length) {
                    merged[count] = nums2[index2++];
                } else if (temp1 == nums1.length) {
                    merged[count] = nums2[index2++];
                } else if (temp2 == nums2.length) {
                    merged[count] = nums1[index1++];
                }
            }
            count++;
        }
        while (index2 < nums2.length) {
            merged[count++] = nums2[index2++];
        }
        while (index1 < nums1.length) {
            merged[count++] = nums1[index1++];
        }
        return merged;
    }

    public static void main(String[] args) {
        MaxNumber maxNumber = new MaxNumber();
        // Arrays.stream(maxNumber.maxNumber(new int[] { 3, 4, 6, 5 }, new int[] { 9, 1, 2, 5, 8, 3 }, 5))
        //         .forEach(System.out::print);
        // ;
        // System.out.println();
        // Arrays.stream(maxNumber.maxNumber(new int[] { 6, 7 }, new int[] { 6, 0, 4 }, 5)).forEach(System.out::print);
        // ;
        // System.out.println();
        // Arrays.stream(maxNumber.maxNumber(new int[] { 3, 9 }, new int[] { 8, 9 }, 3)).forEach(System.out::print);
        // ;
        // System.out.println();
        Arrays.stream(maxNumber.maxNumber(new int[] { 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1 }, new int[] { 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1 }, 100))
                .forEach(System.out::print);
        ;
    }
}
