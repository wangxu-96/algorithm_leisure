package com.at.wangxu.leetcode;

/**
 * 面试题 08.03. 魔术索引
 * <p>
 * 魔术索引。 在数组A[0...n-1]中，有所谓的魔术索引，满足条件A[i] = i。给定一个有序整数数组，编写一种方法找出魔术索引，若有的话，在数组A中找出一个魔术索引，如果没有，则返回-1。若有多个魔术索引，返回索引值最小的一个。
 * <p>
 * 示例1:
 * <p>
 * 输入：nums = [0, 2, 3, 4, 5]
 * 输出：0
 * 说明: 0下标的元素为0
 * 示例2:
 * <p>
 * 输入：nums = [1, 1, 1]
 * 输出：1
 * 说明:
 * <p>
 * nums长度在[1, 1000000]之间
 * 此题为原书中的 Follow-up，即数组中可能包含重复元素的版本
 */
public class FindMagicIndex {


    public int findMagicIndex(int[] nums) {
        //从左到右循环遍历。官方题解为二分思想，但是好像还没有直接遍历效率高
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == i)
//                return i;
//        }
//        return -1;
        return findMin(nums, 0, nums.length);
    }

    public int findMin(int[] nums,int l,int r) {

        if (l > r)
            return -1;
        int m = (l + r) / 2;
        //先找左边
        int min = findMin(nums, l, m - 1);
        if (min != -1)
            return min;
        //判断当前节点
        if (nums[m] == m)
            return m;
        //再找右边
        return findMin(nums, m + 1, r);
    }

    public static void main(String[] args) {
        FindMagicIndex magicIndex = new FindMagicIndex();
        System.out.println(magicIndex.findMagicIndex(new int[]{0, 2, 3, 4, 5}));
        System.out.println(magicIndex.findMagicIndex(new int[]{1, 1, 1}));
    }
}
