package com.at.wangxu.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

@SuppressWarnings({"unused"})
public class LargestSubMatrix {

    public int largestSubMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(this::maxContinuous));

        return 0;
    }

    private int maxContinuous(int[] array) {
        int start = 0;
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) continue;
            max = Math.max(max, (i - start + 1));
            start = i;
        }
        return max;
    }
}
