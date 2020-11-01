package com.at.wangxu.leetcode;

/**
 * 463. 岛屿的周长 给定一个包含 0 和 1 的二维网格地图，其中 1 表示陆地 0 表示水域。
 * 
 * 网格中的格子水平和垂直方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
 * 
 * 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100
 * 。计算这个岛屿的周长。
 * 
 *  
 * 
 * 示例 :
 * 
 * 输入: [[0,1,0,0], [1,1,1,0], [0,1,0,0], [1,1,0,0]]
 * 
 * 输出: 16
 * 
 * 解释: 它的周长是下面图片中的 16 个黄色的边：
 */
public class IslandPerimeter {

    static int[][] direct = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public int islandPerimeter(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1)
                    count += perimeter(i, j, grid);
            }
        }
        return count;
    }

    private int perimeter(int i, int j, int[][] grid) {
        int init = 4;
        for (int k = 0; k < direct.length; k++) {
            int dx = i + direct[k][0];
            int dy = j + direct[k][1];
            if(dx < 0 || dy < 0 || dx >= grid.length || dy >= grid[0].length) continue;
            if (grid[dx][dy] == 1) init --;
        }
        return init;
    }

    public static void main(String[] args) {
        IslandPerimeter islandPerimeter = new IslandPerimeter();

        System.out.println(islandPerimeter
                .islandPerimeter(new int[][] { { 0, 1, 0, 0 }, { 1, 1, 1, 0 }, { 0, 1, 0, 0 }, { 1, 1, 0, 0 } }));
    }
}
