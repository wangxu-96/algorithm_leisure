package com.at.wangxu.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 529. 扫雷游戏
 * 让我们一起来玩扫雷游戏！
 * <p>
 * 给定一个代表游戏板的二维字符矩阵。 'M' 代表一个未挖出的地雷，'E' 代表一个未挖出的空方块，'B' 代表没有相邻（上，下，左，右，和所有4个对角线）地雷的已挖出的空白方块，数字（'1' 到 '8'）表示有多少地雷与这块已挖出的方块相邻，'X' 则表示一个已挖出的地雷。
 * <p>
 * 现在给出在所有未挖出的方块中（'M'或者'E'）的下一个点击位置（行和列索引），根据以下规则，返回相应位置被点击后对应的面板：
 * <p>
 * 如果一个地雷（'M'）被挖出，游戏就结束了- 把它改为 'X'。
 * 如果一个没有相邻地雷的空方块（'E'）被挖出，修改它为（'B'），并且所有和其相邻的未挖出方块都应该被递归地揭露。
 * 如果一个至少与一个地雷相邻的空方块（'E'）被挖出，修改它为数字（'1'到'8'），表示相邻地雷的数量。
 * 如果在此次点击中，若无更多方块可被揭露，则返回面板。
 *  
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入:
 * <p>
 * [['E', 'E', 'E', 'E', 'E'],
 * ['E', 'E', 'M', 'E', 'E'],
 * ['E', 'E', 'E', 'E', 'E'],
 * ['E', 'E', 'E', 'E', 'E']]
 * <p>
 * Click : [3,0]
 * <p>
 * 输出:
 * <p>
 * [['B', '1', 'E', '1', 'B'],
 * ['B', '1', 'M', '1', 'B'],
 * ['B', '1', '1', '1', 'B'],
 * ['B', 'B', 'B', 'B', 'B']]
 * <p>
 * 解释:
 * <p>
 * 示例 2：
 * <p>
 * 输入:
 * <p>
 * [['B', '1', 'E', '1', 'B'],
 * ['B', '1', 'M', '1', 'B'],
 * ['B', '1', '1', '1', 'B'],
 * ['B', 'B', 'B', 'B', 'B']]
 * <p>
 * Click : [1,2]
 * <p>
 * 输出:
 * <p>
 * [['B', '1', 'E', '1', 'B'],
 * ['B', '1', 'X', '1', 'B'],
 * ['B', '1', '1', '1', 'B'],
 * ['B', 'B', 'B', 'B', 'B']]
 * <p>
 * 解释:
 * <p>
 *  
 * <p>
 * 注意：
 * <p>
 * 输入矩阵的宽和高的范围为 [1,50]。
 * 点击的位置只能是未被挖出的方块 ('M' 或者 'E')，这也意味着面板至少包含一个可点击的方块。
 * 输入面板不会是游戏结束的状态（即有地雷已被挖出）。
 * 简单起见，未提及的规则在这个问题中可被忽略。例如，当游戏结束时你不需要挖出所有地雷，考虑所有你可能赢得游戏或标记方块的情况。
 */
public class UpdateBoard {
    int[] vectorX = new int[]{-1, 1, 0, 0, -1, 1, -1, 1};
    int[] vectorY = new int[]{0, 0, -1, 1, -1, -1, 1, 1};
    boolean[][] visited;

    int row, column;

    public char[][] updateBoard(char[][] board, int[] click) {
        row = board.length;
        column = board[0].length;
        visited = new boolean[row][column];
        int x = click[0];
        int y = click[1];
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
            return board;
        }

        bfs(board, x, y);

        return board;
    }

    public void dfs(char[][] board, int x, int y) {
        if (x < 0 || x >= row || y < 0 || y >= column || board[x][y] != 'E')
            return;
        int count = getCount(board, x, y);
        if (count == 0)
            board[x][y] = 'B';
        else
            board[x][y] = (char) (count + 48);
        for (int i = 0; i < 8 && board[x][y] == 'B'; i++) {
            int dx = x + vectorX[i];
            int dy = y + vectorY[i];
            dfs(board, dx, dy);
        }
    }

    public void bfs(char[][] board, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int m = poll[0];
            int n = poll[1];
            int count = getCount(board, m, n);
            if (count == 0)
                board[m][n] = 'B';
            else
                board[m][n] = (char) (count + 48);

            for (int i = 0; i < 8 && board[m][n] == 'B'; i++) {
                int dx = m + vectorX[i];
                int dy = n + vectorY[i];
                if (dx >= 0 && dx < row && dy >= 0 && dy < column && board[dx][dy] == 'E' && !visited[dx][dy]){
                    queue.add(new int[]{dx, dy});
                    visited[dx][dy] = true;
                }
            }
        }
    }

    public int getCount(char[][] board, int x, int y) {
        //上 下 左 右 左上 左下 右上 右下
        int sum = 0;
        for (int i = 0; i < 8; i++) {
            int dx = x + vectorX[i];
            int dy = y + vectorY[i];
            if (dx >= 0 && dx < row && dy >= 0 && dy < column && board[dx][dy] == 'M')
                sum++;
        }
        return sum;
    }

    public static void main(String[] args) {
        char[][] chars = new UpdateBoard().updateBoard(new char[][]{{'E', 'E', 'E', 'E', 'E'}, {'E', 'E', 'M', 'E', 'E'}, {'E', 'E', 'E', 'E', 'E'}, {'E', 'E', 'E', 'E', 'E'}}, new int[]{3, 0});
        for (char[] aChar : chars) {
            for (char c : aChar) {
                System.out.print(c + "\t");
            }
            System.out.println();
        }
    }
}
