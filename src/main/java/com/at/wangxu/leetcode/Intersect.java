package com.at.wangxu.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 350. 两个数组的交集 II
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * 示例 2:
 * <p>
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 * <p>
 * <p>
 * 说明：
 * <p>
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
 * 我们可以不考虑输出结果的顺序。
 */
public class Intersect {

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            Integer integer = map.getOrDefault(i, 0);
            map.put(i, integer + 1);
        }

        int[] result = new int[Math.max(nums1.length, nums2.length)];
        int index = 0;
        for (int i : nums2) {
            Integer orDefault = map.getOrDefault(i, 0);
            if (orDefault != 0) {
                result[index++] = i;
                map.put(i, orDefault - 1);
            }
        }
        return Arrays.copyOf(result, index);
    }

    public int[] sorted(int[] nums1,int[] nums2){
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0,j = 0,k=0;
        int[] result = new int[Math.max(nums1.length, nums2.length)];
        while (i < nums1.length && j < nums2.length){
            if (nums1[i] < nums2[j]){
                i++;
            }else if (nums1[i] > nums2[j]){
                j++;
            }else {
                result[k++] = nums1[i];
                i++;
                j++;
            }
        }
        return Arrays.copyOf(result, k);
    }



    public static void main(String[] args) {
        Intersect intersect = new Intersect();
        int[] intersect1 = intersect.sorted(new int[]{1, 2, 2, 1}, new int[]{2, 2});
        Arrays.stream(intersect1).forEach(System.out::println);
    }
}
