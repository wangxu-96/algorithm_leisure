package com.at.wangxu.leetcode;

/**
 * 130. 被围绕的区域
 * <p>
 * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 * <p>
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 * <p>
 * 示例:
 * <p>
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * 运行你的函数后，矩阵变为：
 * <p>
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * 解释:
 * <p>
 * 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 */
public class Solve {

    int row, column;


    //为四条边中的O关联的O点是不被包围的
    public void solve(char[][] board) {

        row = board.length;
        if (row == 0)
            return;
        column = board[0].length;
        //从四条边出发的O节点能访问到的O节点,记为1
        int[][] visited = new int[row][column];
        for (int i = 0; i < row; i++) {
            dfs(board, i, 0, visited);
            dfs(board, i, column - 1, visited);
        }

        for (int j = 1; j < column - 1; j++) {
            dfs(board, 0, j, visited);
            dfs(board, row - 1, j, visited);
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (visited[i][j] == 1)
                    board[i][j] = 'O';
                else if (board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }
    }


    /**
     * 以x y 为初始点去找为O的点
     * @param board board
     * @param x x
     * @param y y
     * @param visited visited
     */
    public void dfs(char[][] board, int x, int y, int[][] visited) {

        if (x < 0 || x >= row || y < 0 || y >= column || board[x][y] != 'O' || visited[x][y] == 1) {
            return;
        }

        visited[x][y] = 1;
        dfs(board, x + 1, y, visited);
        dfs(board, x - 1, y, visited);
        dfs(board, x, y + 1, visited);
        dfs(board, x, y - 1, visited);


    }

    public static void main(String[] args) {
        Solve solve = new Solve();
        char[][] chars = new char[][]{
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}};
        solve.solve(chars);
        for (char[] aChar : chars) {
            for (char c : aChar) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
}
