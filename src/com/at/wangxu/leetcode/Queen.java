package com.at.wangxu.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 51. N 皇后
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 */
class Queen {
    static char[][] board;
    static List<List<String>> res = new ArrayList<>();

    // find next valid position for Q by rows
    public static void backtrack(int i) {
        if (i == board.length) {
            res.add(construct(board));
            return;
        }

        // in each row, find valid positions
        for (int j = 1; j <= board.length - 1; j++) {
            if (isValid(board, i, j)) {
                board[i][j] = 'Q';
                backtrack(i + 1); // by rows
                board[i][j] = '.';
            }
        }
    }

    // only need to check these cells: north or northwest or northeast of board[i][j]
    public static boolean isValid(char[][] board, int i, int j) {
        for (int k = 1; k <= i - 1; k++) {
            if (board[i - k][j] == 'Q') {
                return false;
            }
        }
        for (int k = 1; k <= i - 1 && k <= j - 1; k++) {
            if (board[i - k][j - k] == 'Q') {
                return false;
            }
        }
        for (int k = 1; k <= i - 1 && k <= board.length - 1 - j; k++) {
            if (board[i - k][j + k] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static List<String> construct(char[][] board) {
        List<String> list = new ArrayList<>();

        for (int i = 1; i <= board.length - 1; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 1; j <= board.length - 1; j++) {
                sb.append(board[i][j]);
            }
            list.add(sb.toString());
        }

        return list;
    }

    public static List<List<String>> solveNQueens(int n) {
        board = new char[n + 1][n + 1];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = '.';
            }
        }

        backtrack(1);

        return res;
    }

    List<List<String>> queen = new ArrayList<>();
    int[] a, b, c;
    int[][] k;
    int queenNum;
    int inc;

    public void queen(int n) {
        a = new int[n + 1];
        b = new int[n * 2 + 1];
        c = new int[n * 2 + 1];
        k = new int[n + 1][n + 1];
        queenNum = n;
        lay(1);
    }

    /**
     * a[j] 表示j列上有无皇后
     * b[j-i+queenNum]表示左上方有无皇后；方向一的斜线为从左上到右下方向，同一条斜线上的每个位置满足行下标与列下标之差相等
     * c[j+i]表示右上方有无皇后；方向二的斜线为从右上到左下方向，同一条斜线上的每个位置满足行下标与列下标之和相等
     * @param i 行
     */
    private void lay(int i) {
        int j = 0, t, u;
        while (++j <= queenNum) {
            if (a[j] + b[j - i + queenNum] + c[j + i] == 0) {
                k[i][j] = a[j] = b[j - i + queenNum] = c[j + i] = 1;
                if (i < queenNum)
                    lay(i + 1);
                else {
                    ++inc;
                    List<String> list = new ArrayList<>();
                    for (u = queenNum; u >= 1; --u) {
                        StringBuilder stringBuilder = new StringBuilder();
                        for (t = queenNum; t >= 1; --t) {
                            if (k[t][u] == 1) {
                                stringBuilder.append("Q");
                            } else {
                                stringBuilder.append(".");
                            }
                        }
                        list.add(stringBuilder.toString());
                    }
                    queen.add(list);
                }
                a[j] = b[j - i + queenNum] = c[j + i] = k[i][j] = 0;
            }
        }
    }

    public static void main(String[] args) {
//        int n = 8;
//
//        solveNQueens(n);
//
//        System.out.println("when n=" + n + ", there are " + res.size() + " solutions:\n");
//        for (List<String> list : res){
//            for (String row : list){
//                for (int i = 0; i < row.length(); i++){
//                    System.out.print(row.charAt(i) + " ");
//                }
//                System.out.println();
//            }
//            System.out.println();
//        }
        Queen queen = new Queen();

        int n = 8;

        queen.queen(n);

        res = queen.queen;
        System.out.println("when n=" + n + ", there are " + res.size() + " solutions:\n");
        for (List<String> list : res) {
            for (String row : list) {
                for (int i = 0; i < row.length(); i++) {
                    System.out.print(row.charAt(i) + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
