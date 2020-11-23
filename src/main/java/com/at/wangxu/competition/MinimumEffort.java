package com.at.wangxu.competition;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 5608. 完成所有任务的最少初始能量
 */
public class MinimumEffort {

    public int minimumEffort(int[][] tasks) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2) {
                if (o1[1] - o1[0] == o2[1] - o2[0]) return o2[1] - o1[1];
                return o2[1] - o2[0] - (o1[1] - o1[0]);
            };
        });
        for (int i = 0; i < tasks.length; i++) {
            queue.offer(tasks[i]);
        }

        int start = 0;
        int remain = 0;
        while (!queue.isEmpty()) {
            int[] ints = queue.poll();
            if (remain < ints[1]) {
                int sub = ints[1] - remain;
                remain += sub;
                start += sub;
            }
            remain = remain - ints[0];

        }
        return start;
    }

    public static void main(String[] args) {
        MinimumEffort minimumEffort = new MinimumEffort();
        System.out.println(minimumEffort.minimumEffort(new int[][] { { 1, 2 }, { 2, 4 }, { 4, 8 } }));
        System.out.println(
                minimumEffort.minimumEffort(new int[][] { { 1, 3 }, { 2, 4 }, { 10, 11 }, { 10, 12 }, { 8, 9 } }));
        System.out.println(minimumEffort
                .minimumEffort(new int[][] { { 1, 7 }, { 2, 8 }, { 3, 9 }, { 4, 10 }, { 5, 11 }, { 6, 12 } }));
    }
}
