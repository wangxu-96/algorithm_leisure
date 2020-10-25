package com.at.wangxu.competition;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 5548. 最小体力消耗路径
 */
public class MinimumEffortPath {

    List<Integer> list = new ArrayList<>();
    int row = 0;
    int column = 0;
    boolean[][] visited;

    public int minimumEffortPath(int[][] heights) {
        row = heights.length;
        column = heights[0].length;
        visited = new boolean[row][column];
        dfs(heights,0,0,0,visited, heights[0][0]);

        return list.stream().min(Integer::compareTo).get();
    }


    public void dfs(int[][] heights,int row,int column,int max,boolean[][] visited,int pre){

        if ((row == this.row && column == this.column - 1) || (row == this.row - 1 && column == this.column)){
            list.add(max);
            return;
        }
        if (row >= this.row || row < 0 || column >= this.column || column < 0 || visited[row][column])
            return;
        if (list.size() > 0 && max >= list.stream().min(Integer::compareTo).get()){
            return;
        }

        visited[row][column] = true;
        max = Math.max(Math.abs(heights[row][column]- pre) ,max);
        pre = heights[row][column];

        dfs(heights, row + 1, column, max, visited, pre);
        dfs(heights, row , column+ 1, max, visited, pre);
        dfs(heights, row - 1, column, max, visited, pre);
        dfs(heights, row , column- 1, max, visited, pre);

        visited[row][column] = false;

    }

    private static final int[][] DIRS = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int minimumEffortPath1(int[][] heights) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int n = heights.length;
        int m = heights[0].length;
        boolean[][] seen = new boolean[n][m];
        pq.offer(new int[] { 0, 0, 0 });

        while (!pq.isEmpty()) {
            final int[] curr = pq.remove();
            int x = curr[1];
            int y = curr[2];
            if (x == n - 1 && y == m - 1) {
                return curr[0];
            }
            if (seen[x][y]) {
                continue;
            }
            seen[x][y] = true;
            for (int[] dir : DIRS) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    pq.offer(
                            new int[] { Math.max(curr[0], Math.abs(heights[x][y] - heights[nx][ny])), nx, ny });
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        MinimumEffortPath effortPath = new MinimumEffortPath();

//        System.out.println(effortPath.minimumEffortPath(new int[][]{{1,2,2},{3,8,2},{5,3,5}}));
//        System.out.println(effortPath.minimumEffortPath(new int[][]{{4,3,4,10,5,5,9,2}, {10,8,2,10,9,7,5,6}, {5,8,10,10,10,7,4,2}, {5,1,3,1,1,3,1,9}, {6,4,10,6,10,9,4,6}}));
//        System.out.println(effortPath.minimumEffortPath(new int[][]{{1,2,3},{3,8,4},{5,3,5}}));
//        System.out.println(effortPath.minimumEffortPath(new int[][]{{1,2,1,1,1},{1,2,1,2,1},{1,2,1,2,1},{1,2,1,2,1},{1,1,1,2,1}}));
        System.out.println(effortPath.minimumEffortPath1(new int[][]{{10,8},{10,8},{1,2},{10,3},{1,3},{6,3},{5,2}}));
    }
}
