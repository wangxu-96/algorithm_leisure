package com.at.wangxu.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/intersection-of-two-arrays 349. 两个数组的交集
 * 
 * 给定两个数组，编写一个函数来计算它们的交集。
 * 
 *  
 * 
 * 示例 1：
 * 
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2] 输出：[2] 示例 2：
 * 
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4] 输出：[9,4]  
 * 
 * 说明：
 * 
 * 输出结果中的每个元素一定是唯一的。 我们可以不考虑输出结果的顺序。
 */
public class Intersection {

    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] res = new int[Math.min(nums1.length, nums2.length)];
        int start = 0;
        int l = 0, r = 0;
        while (l < nums1.length && r < nums2.length) {
            if (l > 0 && nums1[l] == nums1[l - 1]) {
                l++;
                continue;
            }
            if (r > 0 && nums2[r] == nums2[r - 1]) {
                r++;
                continue;
            }
            if (nums1[l] == nums2[r]) {
                res[start++] = nums1[l];
                l++;
                r++;
            } else if (nums1[l] < nums2[r]) {
                l++;
            } else {
                r++;
            }
        }
        return Arrays.copyOf(res, start);
    }

    public static void main(String[] args) {
        Intersection intersection = new Intersection();
        Arrays.stream(intersection.intersection(new int[] { 1, 2, 2, 1 }, new int[] { 2, 2 }))
                .forEach(System.out::println);
        Arrays.stream(intersection.intersection(new int[] { 4, 9, 5 }, new int[] { 9, 4, 9, 8, 4 }))
                .forEach(System.out::println);
    }

}
