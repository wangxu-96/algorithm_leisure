package com.at.wangxu.leetcode;

import java.util.*;

public class MedianFinder {

    PriorityQueue<Integer> maxQueue;//存储大的值，使用最小堆
    PriorityQueue<Integer> minQueue;//存储小的值，使用最大堆

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        maxQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        minQueue = new PriorityQueue<>();
    }

    public void addNum(int num) {
        minQueue.offer(num);
        maxQueue.offer(minQueue.poll());
        if (maxQueue.size() > minQueue.size()){
            minQueue.offer(maxQueue.poll());
        }
    }

    //0,1,2,3,4,5
    public double findMedian() {

        if(minQueue.size() > maxQueue.size()){
            return (double) minQueue.peek();
        }else{
            return (double) (minQueue.peek() + maxQueue.peek()) / 2;
        }
    }

    public static void main(String[] args) {
        MedianFinder finder = new MedianFinder();
        finder.addNum(-1);
        System.out.println(finder.findMedian());
        finder.addNum(-2);
        System.out.println(finder.findMedian());
        finder.addNum(-3);
        System.out.println(finder.findMedian());
        finder.addNum(-4);
        System.out.println(finder.findMedian());
        finder.addNum(-5);
        System.out.println(finder.findMedian());
        Random random = new Random();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            finder.addNum(random.nextInt(10));
            System.out.println(finder.findMedian());
        }
        System.out.println("cost time " + (System.currentTimeMillis() - startTime));
    }
}
