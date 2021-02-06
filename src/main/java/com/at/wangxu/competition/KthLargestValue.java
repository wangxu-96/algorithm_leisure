package com.at.wangxu.competition;

import java.util.PriorityQueue;

public class KthLargestValue {

    public int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] xor = new int[matrix.length][matrix[0].length];

        xor[0][0] = matrix[0][0];

        for (int j = 1; j < n; j++) {
            xor[0][j] = xor[0][j - 1] ^ matrix[0][j];
        }

        for (int i = 1; i < m; i++) {
            xor[i][0] = xor[i - 1][0] ^ matrix[i][0];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                xor[i][j] = xor[i - 1][j] ^ xor[i][j - 1] ^ xor[i - 1][j - 1] ^ matrix[i][j];
            }
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int[] ints : xor) {
            for (int anInt : ints) {
                if (queue.size() < k) {
                    queue.add(anInt);
                } else {
                    if (anInt < queue.peek()) continue;
                    queue.add(anInt);
                    queue.poll();
                }
            }
        }

        return queue.poll();
    }

    public static void main(String[] args) {
        KthLargestValue largestValue = new KthLargestValue();

        System.out.println(largestValue.kthLargestValue(new int[][]{{5, 2}, {1, 6}}, 2));
    }
}
