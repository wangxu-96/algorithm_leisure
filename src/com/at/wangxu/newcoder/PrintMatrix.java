package com.at.wangxu.newcoder;

import java.util.ArrayList;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵：
 * 1 2 3 4
 * 5 6 7 8
 * 9 10 11 12
 * 13 14 15 16
 * 则依次打印出数字
 * 1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class PrintMatrix {
    //1-right;2-down;3-left;4-up
    int[] direction = new int[]{1, 2, 3, 4};
    int row, column;
    boolean[][] visited;
    ArrayList<Integer> list = new ArrayList<>();
    int[] arr;
    int index = 0;

    public ArrayList<Integer> printMatrix(int[][] matrix) {
        row = matrix.length;
        column = matrix[0].length;
        arr = new int[row*column];
        visited = new boolean[row][column];

        dfs(matrix, 0, 0, direction[0]);
        return list;
    }

    /**
     * dfs搜索，按照如下两个原则
     * 1。按照 右 下 左 上的原则
     * 2。前一个是哪个方向，优先选择哪个方向
     * @param matrix matrix
     * @param row row
     * @param column column
     * @param direction direction
     */
    private void dfs(int[][] matrix, int row, int column, int direction) {
        if (row < 0 || row >= this.row || column < 0 || column >= this.column || visited[row][column])
            return;
        list.add(matrix[row][column]);
        arr[index++] = matrix[row][column];
        visited[row][column] = true;

        if (direction == this.direction[0]) {
            dfs(matrix, row, column + 1, this.direction[0]);
            dfs(matrix, row + 1, column, this.direction[1]);
            dfs(matrix, row, column - 1, this.direction[2]);
            dfs(matrix, row - 1, column, this.direction[3]);
        } else if (direction == this.direction[1]) {
            dfs(matrix, row + 1, column, this.direction[1]);
            dfs(matrix, row, column + 1, this.direction[0]);
            dfs(matrix, row, column - 1, this.direction[2]);
            dfs(matrix, row - 1, column, this.direction[3]);
        } else if (direction == this.direction[2]) {
            dfs(matrix, row, column - 1, this.direction[2]);
            dfs(matrix, row, column + 1, this.direction[0]);
            dfs(matrix, row + 1, column, this.direction[1]);
            dfs(matrix, row - 1, column, this.direction[3]);
        } else {
            dfs(matrix, row - 1, column, this.direction[3]);
            dfs(matrix, row, column + 1, this.direction[0]);
            dfs(matrix, row + 1, column, this.direction[1]);
            dfs(matrix, row, column - 1, this.direction[2]);
        }
    }

    public static void main(String[] args) {
//        ArrayList<Integer> integers = new PrintMatrix().printMatrix(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8,}, {9, 10, 11, 12}, {13, 14, 15, 16}});
        ArrayList<Integer> integers = new PrintMatrix().printMatrix(new int[][]{{1}, {2}, {3}, {4},{5}});

        integers.forEach(System.out::println);
    }
}
