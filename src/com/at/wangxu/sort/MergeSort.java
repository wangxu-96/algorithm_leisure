package com.at.wangxu.sort;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort {


    public static void merSort(int[] arr, int l, int r) {
        if (l >= r)
            return;
        int mid = (l + r) / 2;
        merSort(arr, l, mid);
        merSort(arr, mid + 1, r);
        merge(arr, l, mid, r);

    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 1, 7, 9, 5, 8};
        long startTime = System.currentTimeMillis();
        merSort(arr, 0, arr.length - 1);
        long endTime = System.currentTimeMillis();
        System.out.println("cost time" + (endTime - startTime));
        Arrays.stream(arr).forEach(System.out::println);
    }

    public static void merge(int[] arr, int l, int m, int r) {

        int[] clone = arr.clone();
        // 定义一个 k 指针表示从什么位置开始修改原来的数组，i 指针表示左半边的起始位置，j 表示右半边的起始位置
        int k = l, i = l, j = m + 1;

        while (k <= r) {
            if (i > m) {
                arr[k++] = clone[j++];
            } else if (j > r) {
                arr[k++] = clone[i++];
            } else if (arr[i] < arr[j]) {
                arr[k++] = clone[i++];
            } else {
                arr[k++] = clone[j++];
            }
        }

    }


}
