package com.at.wangxu.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort {


    public static int[] bubbleSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {

            boolean hasChanged = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    hasChanged = true;
                }
            }
            //如果有某一轮比较没有发生交换，则说明数组已经有序，无需再排序
            if (!hasChanged)
                break;
        }
        return arr;
    }

    private static void swap(int[] arr, int j, int i) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 7, 5, 8, 9};
        Arrays.stream(bubbleSort(arr)).forEach(System.out::println);

    }
}
