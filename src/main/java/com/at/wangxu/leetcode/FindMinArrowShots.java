package com.at.wangxu.leetcode;

import java.util.Arrays;

/**
 * 452. 用最少数量的箭引爆气球
 * https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons/
 */
public class FindMinArrowShots {

    public int findMinArrowShots(int[][] points) {

        if(points.length == 0) return 0;
        Arrays.sort(points, (p1, p2) -> p1[1] < p2[1] ? -1 : 1);
        int res = 1;
        int pre = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > pre) {
                res++;
                pre = points[i][1];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        FindMinArrowShots findMinArrowShots = new FindMinArrowShots();
        System.out.println(
                findMinArrowShots.findMinArrowShots(new int[][] { { 10, 16 }, { 2, 8 }, { 1, 6 }, { 7, 12 } }));
        System.out.println(findMinArrowShots.findMinArrowShots(new int[][] { { 1, 2 }, { 3, 4 }, { 5, 6 }, { 7, 8 } }));
        System.out.println(findMinArrowShots.findMinArrowShots(new int[][] { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 5 } }));
        System.out.println(findMinArrowShots.findMinArrowShots(new int[][] { { 1, 2 } }));
        System.out.println(findMinArrowShots.findMinArrowShots(new int[][] { { 2, 3 }, { 2, 2 } }));
    }
}
