package com.at.wangxu.leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 621. 任务调度器
 */
public class LeastInterval {

    public int leastIntervalOffical(char[] tasks, int n) {

        Map<Character, Integer> freq = new HashMap<Character, Integer>();
        // 最多的执行次数
        int maxExec = 0;
        for (char ch : tasks) {
            int exec = freq.getOrDefault(ch, 0) + 1;
            freq.put(ch, exec);
            maxExec = Math.max(maxExec, exec);
        }

        // 具有最多执行次数的任务数量
        int maxCount = 0;
        Set<Map.Entry<Character, Integer>> entrySet = freq.entrySet();
        for (Map.Entry<Character, Integer> entry : entrySet) {
            int value = entry.getValue();
            if (value == maxExec) {
                ++maxCount;
            }
        }

        return Math.max((maxExec - 1) * (n + 1) + maxCount, tasks.length);

    }

    public int leastInterval(char[] tasks, int n) {
        // 待命的个数
        int count = 0;

        int size = tasks.length;
        int[] cnts = new int[26];
        for (char c : tasks) {
            cnts[c - 'A']++;
        }
        PriorityQueue<Character> priorityQueue = new PriorityQueue<>(new Comparator<Character>() {
            public int compare(Character o1, Character o2) {
                return cnts[o2 - 'A'] - cnts[o1 - 'A'];
            };
        });

        for (int i = 0; i < cnts.length; i++) {
            if (cnts[i] == 0)
                continue;
            priorityQueue.offer((char) (i + 'A'));
        }

        while (size > 0) {
            int tempN = n + 1;
            Set<Character> removed = new HashSet<>();
            while (size > 0 && tempN > 0) {
                if (priorityQueue.isEmpty()) {
                    count += tempN;
                    break;
                }
                char poll = priorityQueue.poll();
                removed.add(poll);
                cnts[poll - 'A']--;
                tempN--;
                size--;
            }
            for (Character character : removed) {
                if (cnts[character - 'A'] > 0)
                    priorityQueue.offer(character);
            }
        }
        return count + tasks.length;
    }

    public static void main(String[] args) {
        LeastInterval leastInterval = new LeastInterval();
        System.out.println(leastInterval.leastInterval(new char[] { 'A', 'A', 'A', 'B', 'B', 'B' }, 2));
        System.out.println(leastInterval.leastInterval(new char[] { 'A', 'A', 'A', 'B', 'B', 'B' }, 0));
        System.out.println(leastInterval
                .leastInterval(new char[] { 'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G' }, 2));
    }

}
