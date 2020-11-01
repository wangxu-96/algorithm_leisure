package com.at.wangxu.leetcode;

/**
 * 52. N皇后 II
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 * 上图为 8 皇后问题的一种解法。
 *
 * 给定一个整数 n，返回 n 皇后不同的解决方案的数量。
 *
 * 示例:
 *
 * 输入: 4
 * 输出: 2
 * 解释: 4 皇后问题存在如下两个不同的解法。
 * [
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 *  
 *
 * 提示：
 *
 * 皇后，是国际象棋中的棋子，意味着国王的妻子。皇后只做一件事，那就是“吃子”。当她遇见可以吃的棋子时，就迅速冲上去吃掉棋子。当然，她横、竖、斜都可走一或 N-1 步，可进可退。（引用自 百度百科 - 皇后 ）
 *
 */
public class TotalNQueens {

    int count = 0;
    int N = 0;
    public int totalNQueens(int n) {
        boolean[] row = new boolean[n];
        boolean[] column = new boolean[n];
        boolean[] rightDown = new boolean[n * 2];
        boolean[] rightUp = new boolean[n * 2];
        N = n;
        //graph
        int[][] arr = new int[n][n];

        dfs(0,arr,row,column,rightDown,rightUp);
        return count;
    }

    private void dfs(int i, int[][] arr, boolean[] row, boolean[] column, boolean[] rightDown, boolean[] rightUp) {
        if (i == N ){
            count ++;
            return;
        }
        for (int k = i; k < arr.length; k++) {
            for (int l = 0; l < arr[0].length; l++) {
                if (row[k] || column[l] || rightDown[i - l + N] || rightUp[i + l ])
                    continue;

                row[k] = true;
                column[l] = true;
                rightDown[i - l + N] = true;
                rightUp[i + l] = true;

                dfs(i + 1, arr, row, column, rightDown, rightUp);

                row[k] = false;
                column[l] = false;
                rightDown[i - l + N] = false;
                rightUp[i + l] = false;
            }
        }
    }

    public static void main(String[] args) {
        TotalNQueens nQueens = new TotalNQueens();

        System.out.println(nQueens.totalNQueens(8));
    }
}
