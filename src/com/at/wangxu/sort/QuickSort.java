package com.at.wangxu.sort;

import java.util.Arrays;

public class QuickSort {

    int partition(int[] nums, int l, int r) {

        // 随机选择一个数作为基准值，nums[hi] 就是基准值
        swap(nums, (l + r) / 2, r);

        int i, j;

        // 从左到右用每个数和基准值比较，
        // 若比基准值小，则放到指针 i 所指向的位置。
        // 循环完毕后，i 指针之前的数都比基准值小
        for (i = l, j = l; j < r; j++) {
            if (nums[j] <= nums[r]) {
                swap(nums, i++, j);
            }
        }
        // 末尾的基准值放置到指针 i 的位置，i 指针之后的数都比基准值大
        swap(nums, i, r);
        return i;
    }

    void sort(int[] nums, int l, int r) {

        if (l >= r)
            return;
        int p = partition(nums, l, r);
        sort(nums, l, p - 1);
        sort(nums, p + 1, r);
    }


    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] arr = new int[]{2, 1, 7, 9, 5, 8};
        quickSort.sort(arr, 0, arr.length - 1);
        Arrays.stream(arr).forEach(System.out::println);
    }

    private void swap(int[] nums, int i, int j) {

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
