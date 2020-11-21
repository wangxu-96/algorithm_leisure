package com.at.wangxu.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 973. 最接近原点的 K 个点
 */
public class KClosest {

    static class struct {
        int val;
        int[] arr;

        struct(int val, int[] arr) {
            this.val = val;
            this.arr = arr;
        }
    }

    public int get(int[][] arr,int i ) {
        return arr[i][0] * arr[i][0] + arr[i][1] * arr[i][1];
    }
    public  int partition(int[][] arr, int low, int high) {
        int[] temp = arr[low];
        int pivot = get(arr,low);
        while (low < high) {
            while (low < high && get(arr,high) >= pivot) {
                high--;
            }
            arr[low] = arr[high];
            while (low < high && get(arr,low) <= pivot) {
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = temp;
        return low;
    }

    public  void sort(int[][] arr, int low, int high) {
        if (low < high) {
            int index = partition(arr, low, high);
            sort(arr, low, index - 1);
            sort(arr, index + 1, high);
        }
    }
    public int[][] kClosestSort(int[][] points,int K) {
        
        //sort points
        sort(points,0,points.length - 1);
        return Arrays.copyOfRange(points, 0, K);
    }



    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<struct> queue = new PriorityQueue<>(new Comparator<struct>() {
            public int compare(struct o1, struct o2) {
                return o2.val - o1.val;
            };
        });

        for (int i = 0; i < points.length; ++i) {
            int sqrt = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            if (queue.size() < K) {
                queue.offer(new struct(sqrt, points[i]));
            } else {
                if (queue.peek().val > sqrt) {
                    queue.poll();
                    queue.offer(new struct(sqrt, points[i]));
                }
            }
        }

        int[][] result = new int[K][2];
        int start = 0;
        while (!queue.isEmpty()) {
            struct s = queue.poll();
            result[start++][0] = s.arr[0];
            result[start][1] = s.arr[1];
        }
        return result;
    }

    public static void main(String[] args) {
        KClosest closest = new KClosest();

        closest.kClosestSort(new int[][] { { 3, 3 }, { 5, -1 }, { -2, 4 } }, 2);
    }
}
