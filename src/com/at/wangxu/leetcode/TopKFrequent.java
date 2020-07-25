package com.at.wangxu.leetcode;

import java.util.*;

/**
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 * <p>
 * 输入: nums = [1], k = 1
 * 输出: [1]
 * <p>
 * 提示：
 * <p>
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
 * 你可以按任意顺序返回答案。
 */
public class TopKFrequent {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(count::get));

        for (Integer next : count.keySet()) {
            priorityQueue.add(next);
            if (priorityQueue.size() > k)
                priorityQueue.poll();
        }


        int[] arr = new int[k];
        int index = 0;
        for (Integer integer : priorityQueue) {
            arr[index++] = integer;
        }
        return arr;
    }

    public static void main(String[] args) {
        TopKFrequent frequent = new TopKFrequent();
        //Arrays.stream(frequent.topKFrequent(new int[]{1,1,1,2,2,3}, 2)).forEach(System.out::println);
        //Arrays.stream(frequent.topKFrequent(new int[]{1}, 1)).forEach(System.out::println);
        Arrays.stream(frequent.topKFrequent(new int[]{4, 1, -1, 2, -1, 2, 3}, 2)).forEach(System.out::println);
    }
}
