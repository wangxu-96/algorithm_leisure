package com.at.wangxu.leetcode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回滑动窗口中的最大值。
 * <p>
 * 进阶：
 * <p>
 * 你能在线性时间复杂度内解决此题吗？
 * <p>
 * 示例:
 * <p>
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 * <p>
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 * 1 <= k <= nums.length
 */
public class MaxSlidingWindow {

    /**
     * 构造一个queue，用来存当前最大的值
     *
     * @param nums nums
     * @param k    k
     * @return int[]
     */
    public int[] maxSlidingWindow(int[] nums, int k) {

        int[] result = new int[nums.length - k + 1];
        Deque<Integer> queue = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {

            while (!queue.isEmpty() && nums[queue.getLast()] < nums[i]) {
                queue.removeLast();
            }
            while (!queue.isEmpty() && queue.element() < i - k + 1 && i - k + 1 >= 0) {
                queue.removeFirst();
            }

            queue.offer(i);
            if (i >= k - 1) {
                result[i - k + 1] = nums[queue.getFirst()];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        MaxSlidingWindow slidingWindow = new MaxSlidingWindow();
//        int[] ints = slidingWindow.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
//        Arrays.stream(ints).forEach(System.out::println);
//        int[] ints = slidingWindow.maxSlidingWindow(new int[]{1, 3, 1, 2, 0, 5}, 3);
//        Arrays.stream(ints).forEach(System.out::println);
//        int[] ints = slidingWindow.maxSlidingWindow(new int[]{1, -1}, 1);
//        Arrays.stream(ints).forEach(System.out::println);
        long startTime = System.currentTimeMillis();
        int[] ints = slidingWindow.maxSlidingWindow(new int[]{-7, -8, 7, 5, 7, 1, 6, 0}, 4);
        Arrays.stream(ints).forEach(System.out::println);
        System.out.println("cost time : " + (System.currentTimeMillis() - startTime));
    }
}
