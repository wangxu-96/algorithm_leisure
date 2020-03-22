package com.at.wangxu.leetcode;

/**
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。
 * 如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。
 * 例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
 * <p>
 * [["a","b","c","e"],
 * ["s","f","c","s"],
 * ["a","d","e","e"]]
 * <p>
 * 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
 * <p>
 * 示例 1：
 * <p>
 * 输入：board = [["A","B","C","E"],
 * ["S","F","C","S"],
 * ["A","D","E","E"]],
 * word = "ABCCED"
 * 输出：true
 * <p>
 * 示例 2：
 * <p>
 * 输入：board = [["a","b"],
 * ["c","d"]],
 * word = "abcd"
 * 输出：false
 * <p>
 * 提示：
 * <p>
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 */
public class MatrixExist {

    public boolean exist(char[][] board, String word) {

        if (word == null || word.equals("")) {
            return false;
        }
        //保留数组中已经访问的节点

        boolean[][] isVisited = new boolean[board.length][board[0].length];
        char[] chs = word.toCharArray();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == chs[0]) {
                    if (dfs(board, i, j, isVisited, chs, 0))
                        return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, boolean[][] isVisited, char[] chs, int index) {

        if (index == chs.length) {
            return true;
        }
        if (i < 0 || j < 0 || i == board.length || j == board[0].length || isVisited[i][j] || board[i][j] != chs[index]) {
            return false;
        }
        isVisited[i][j] = true;
        boolean res = dfs(board, i + 1, j, isVisited, chs, index + 1)
                || dfs(board, i - 1, j, isVisited, chs, index + 1)
                || dfs(board, i, j + 1, isVisited, chs, index + 1)
                || dfs(board, i, j - 1, isVisited, chs, index + 1);
        isVisited[i][j] = false;
        return res;
    }

    public static void main(String[] args) {
        MatrixExist exist = new MatrixExist();
        System.out.println(exist.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCCED"));
        System.out.println(exist.exist(new char[][]{{'A', 'B'}, {'C', 'D'}}, "ABCD"));
    }
}
