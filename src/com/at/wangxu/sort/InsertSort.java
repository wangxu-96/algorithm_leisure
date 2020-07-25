package com.at.wangxu.sort;

import java.util.Arrays;

/**
 * 插入排序
 */
public class InsertSort {

    public static int[] insertSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && less(arr[j], arr[j - 1]); j--) {
                swap(arr, j, j-1);
            }
        }
        return arr;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static boolean less(int i, int j) {
        return i < j;
    }


    public static void main(String[] args) {
        Arrays.stream(InsertSort.insertSort(new int[]{1, 2, 1, 7, 8, 9})).forEach(System.out::println);
    }
}
