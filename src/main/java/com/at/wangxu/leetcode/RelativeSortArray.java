package com.at.wangxu.leetcode;

import java.util.Arrays;

/**
 * 1122. 数组的相对排序
 */
public class RelativeSortArray {

    public int[] relativeSortArrayAC(int[] arr1,int[] arr2) {
        int max = 0;
        for (int i : arr1) {
            max = Math.max(i, max);
        }
        int[] count = new int[max + 1];
        int[] result = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            count[arr1[i]] ++;
        }
        int start = 0;
        for (int i = 0; i < arr2.length; i++) {
            int repeat = count[arr2[i]];

            while (repeat -- > 0) {
                result[start ++] = arr2[i];
            }
            count[arr2[i]] = 0;
        }

        for (int i = 0; i < count.length; i++) {
            int repeat = count[i];
            while (repeat -- > 0) {
                result[start ++] = i;
            }
        }

        return result;
    }

    public int[] relativeSortArray(int[] arr1, int[] arr2) {

        int start = 0;
        int p = 0;
        while (p < arr2.length) {
            int pivot = arr2[p++];

            for (int i = start; i < arr1.length; i++) {
                if (arr1[i] == pivot)
                    swap(arr1, start++, i);
            }
        }

        // qucick sort [start,arr1.length]
        sort(arr1, start, arr1.length - 1);
        return arr1;
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

    private void swap(int[] arr1, int start, int i) {
        int temp = arr1[start];
        arr1[start] = arr1[i];
        arr1[i] = temp;
    }

    public static void main(String[] args) {
        RelativeSortArray relativeSortArray = new RelativeSortArray();
        Arrays.stream(relativeSortArray.relativeSortArrayAC(new int[] { 2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19 },
                new int[] { 2, 1, 4, 3, 9, 6 })).forEach(System.out::println);
    }
}
