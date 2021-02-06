package com.at.wangxu.leetcode;

import java.util.PriorityQueue;

public class MaxProfitIV {

    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0) return 0;
        int pre = prices[0];
        int currentIndex = -1;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > pre) {
                if (currentIndex == -1) {
                    currentIndex = i - 1;
                }
            } else {
                if (currentIndex != -1) {
                    priorityQueue.offer(prices[i - 1] - prices[currentIndex]);
                    currentIndex = -1;
                }
            }
            pre = prices[i];
        }
        if (currentIndex != -1) {
            priorityQueue.offer(prices[prices.length - 1] - prices[currentIndex]);
        }
        int res = 0;
        while (k-- > 0 && !priorityQueue.isEmpty()) {
            res += priorityQueue.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        MaxProfitIV maxProfitIV = new MaxProfitIV();
//        System.out.println(maxProfitIV.maxProfit(2, new int[]{2, 4, 1}));
        System.out.println(maxProfitIV.maxProfit(2, new int[]{3, 2, 6, 5, 0, 3}));
    }
}
