package com.at.wangxu.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * 拓扑排序
 * <p>
 * 输入: 4, [[1,0],[2,0],[3,1],[3,2]]
 * 输出: [0,1,2,3] or [0,2,1,3]
 * 解释: 总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
 *      因此，一个正确的课程顺序是 [0,1,2,3] 。另一个正确的排序是 [0,2,1,3] 。
 */
public class TopologicalOrder {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result = new int[numCourses];
        //入度
        int[] degree = new int[numCourses];

        for (int[] prerequisite : prerequisites) {
            degree[prerequisite[0]]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        //入度为0的进queue
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0)
                queue.offer(i);
        }

        int index = 0;
        while (!queue.isEmpty()) {
            //queue出队
            Integer poll = queue.poll();
            result[index++] = poll;

            for (int[] prerequisite : prerequisites) {
                if (prerequisite[1] == poll) {
                    //删除入度
                    degree[prerequisite[0]]--;
                    //入度为0，进queue
                    if (degree[prerequisite[0]] == 0) {
                        queue.offer(prerequisite[0]);
                    }
                }
            }
        }

        return index == numCourses ? result : new int[]{};
    }


    public static void main(String[] args) {
        TopologicalOrder order = new TopologicalOrder();
        int[] order1 = order.findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}});
        Arrays.stream(order1).forEach(System.out::println);
    }
}
