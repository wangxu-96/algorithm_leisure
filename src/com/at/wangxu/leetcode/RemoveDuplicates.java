package com.at.wangxu.leetcode;

import java.util.Arrays;

/**
 * 26. 删除排序数组中的重复项
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 给定数组 nums = [1,1,2],
 * <p>
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 * <p>
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 * <p>
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 */
public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        //判断当前元素与下一个元素是否相等，相等就跳过，不想等就放在index位置，index++
        //最后一个元素没有下一个元素了，所以最后一个元素特殊处理
        //1。如果倒数第二个元素等于最后一个元素，说明倒数第二个元素没有被放在index处，则将最后一个元素放在index处
        //2。如果倒数第二个元素不等于最后一个元素，则最后一个元素放在index处
        //3。综上所述，最后一个元素直接放入index处即可，index++
        //index从0开始，最后返回的是应该是index+1，所以每次都会index++，最后返回index。
        if (nums.length == 1 || nums.length == 0)
            return nums.length;
        int index = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1])
                continue;
            nums[index++] = nums[i];
        }
        nums[index++] = nums[nums.length - 1];
        return index;
    }

    public static void main(String[] args) {
        RemoveDuplicates duplicates = new RemoveDuplicates();
        int[] arr = new int[]{1, 2, 2};
        System.out.println(duplicates.removeDuplicates(arr));
        Arrays.stream(arr).forEach(System.out::println);
    }
}
