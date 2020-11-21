package com.at.wangxu.leetcode;

import java.util.Arrays;

/**
 * 31. 下一个排列
 */
public class NextPermutation {

    public void nextPermutation(int[] nums) {
        for (int i = nums.length - 2; i >= 0 ; i--) {
            for (int j = nums.length - 1; j > i;j --) {
                if (nums[i] < nums[j]) {
                    swap(nums,i,j);
                    quickSort(nums,i + 1);
                    return;
                }
            }
        }
        quickSort(nums,0);
    }
    
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= pivot) {
                high--;
            }
            arr[low] = arr[high];
            while (low < high && arr[low] <= pivot) {
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = pivot;
        return low;
    }

    public static void sort(int[] arr, int low, int high) {
        if (low < high) {
            int index = partition(arr, low, high);
            sort(arr, low, index - 1);
            sort(arr, index + 1, high);
        }
    }
    
    private void quickSort(int[] nums,int k) {
        //nums sort from k    
        sort(nums,k,nums.length - 1);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        NextPermutation nextPermutation = new NextPermutation();
        int[] nums = new int[] { 3, 2, 1 };
        nextPermutation.nextPermutation(nums);
        Arrays.stream(nums).forEach(System.out::println);
    }
}
