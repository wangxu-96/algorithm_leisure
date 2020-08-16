package com.at.wangxu.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 733. 图像渲染
 * <p>
 * 有一幅以二维整数数组表示的图画，每一个整数表示该图画的像素值大小，数值在 0 到 65535 之间。
 * <p>
 * 给你一个坐标 (sr, sc) 表示图像渲染开始的像素值（行 ，列）和一个新的颜色值 newColor，让你重新上色这幅图像。
 * <p>
 * 为了完成上色工作，从初始坐标开始，记录初始坐标的上下左右四个方向上像素值与初始坐标相同的相连像素点，接着再记录这四个方向上符合条件的像素点与他们对应四个方向上像素值与初始坐标相同的相连像素点，……，重复该过程。将所有有记录的像素点的颜色值改为新的颜色值。
 * <p>
 * 最后返回经过上色渲染后的图像。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * image = [[1,1,1],[1,1,0],[1,0,1]]
 * sr = 1, sc = 1, newColor = 2
 * 输出: [[2,2,2],[2,2,0],[2,0,1]]
 * 解析:
 * 在图像的正中间，(坐标(sr,sc)=(1,1)),
 * 在路径上所有符合条件的像素点的颜色都被更改成2。
 * 注意，右下角的像素没有更改为2，
 * 因为它不是在上下左右四个方向上与初始点相连的像素点。
 * 注意:
 * <p>
 * image 和 image[0] 的长度在范围 [1, 50] 内。
 * 给出的初始点将满足 0 <= sr < image.length 和 0 <= sc < image[0].length。
 * image[i][j] 和 newColor 表示的颜色值在范围 [0, 65535]内。
 */
public class FloodFill {
    int row, column;
    int[] x =new int[]{0,0,1,-1};
    int[] y =new int[]{1,-1,0,0};

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor)
            return image;
        row = image.length;
        column = image[0].length;
        int target = image[sr][sc];
        dfs(image, target, sr, sc, newColor);
        return image;
    }



    //DFS实现
    public void dfs(int[][] image, int target, int sr, int sc, int newColor) {
        if (sr >= row || sr < 0 ||sc >= column || sc < 0 ||  image[sr][sc] != target)
            return;
        image[sr][sc] = newColor;
        dfs(image, target, sr + 1, sc, newColor);
        dfs(image, target, sr - 1, sc, newColor);
        dfs(image, target, sr, sc + 1, newColor);
        dfs(image, target, sr, sc - 1, newColor);
    }

    //BFS
    public int[][] BFS(int[][] image,int sr,int sc,int newColor){
        int target = image[sr][sc];
        if (target == newColor)
            return image;
        int row = image.length;;
        int column = image[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr,sc});
        image[sr][sc] = newColor;

        while (!queue.isEmpty()){
            int[] poll = queue.poll();
            //上下左右
            int srcX = poll[0];
            int srcY = poll[1];

            for (int i = 0; i <4; i++) {
                int dx = srcX + x[i];
                int dy = srcY + y[i];
                if (dx >= 0 && dx < row && dy >= 0 && dy < column && image[dx][dy] == target) {
                    queue.offer(new int[]{dx, dy});
                    image[dx][dy] = newColor;
                }
            }
        }
        return image;
    }

    public static void main(String[] args) {
        FloodFill fill = new FloodFill();
        int[][] ints = fill.BFS(new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}, 1, 1, 2);
//        int[][] ints = fill.floodFill(new int[][]{{0,0,0}, {0,1,1}}, 1, 1, 1);
        for (int[] anInt : ints) {
            for (int i : anInt) {
                System.out.println(i);
            }
            System.out.println();
        }
    }
}
