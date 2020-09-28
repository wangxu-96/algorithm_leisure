package com.at.wangxu.leetcode;

/**
 * 79. 单词搜索
 * <p>
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 * 示例:
 * <p>
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * <p>
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 *  
 * <p>
 * 提示：
 * <p>
 * board 和 word 中只包含大写和小写英文字母。
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 1 <= word.length <= 10^3
 */
public class Exist {

    public boolean exist(char[][] board, String word) {
        if (board.length == 0)
            return false;
        int row = board.length;
        int column = board[0].length;
        boolean flag = false;
        boolean[][] booleans = new boolean[row][column];
        char[] chars = word.toCharArray();
        for (int i = 0; i < row && !flag; i++) {
            for (int j = 0; j < column && !flag; j++) {
                if (board[i][j] == word.charAt(0)) {
                    flag = dfs(board, i, j,booleans , row, column, chars,0);
                }
            }
        }
        return flag;
    }

    private boolean dfs(char[][] board, int i, int j, boolean[][] booleans, int row, int column, char[] word,int index) {
        if (i >= row || i < 0 || j >= column || j < 0 || booleans[i][j])
            return false;
        if (board[i][j] == word[index]) {
            if (index == word.length - 1)
                return true;
            booleans[i][j] = true;
            boolean valid = dfs(board, i + 1, j, booleans, row, column, word,index + 1) ||
                    dfs(board, i, j + 1, booleans, row, column, word,index + 1) ||
                    dfs(board, i - 1, j, booleans, row, column, word,index + 1) ||
                    dfs(board, i, j - 1, booleans, row, column, word,index + 1);
            if (valid)
                return true;
            booleans[i][j] = false;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Exist().exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCCED"));
        System.out.println(new Exist().exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "SEE"));
        System.out.println(new Exist().exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCB"));
        //A B C E
        //S F E S
        //A D E E
        System.out.println(new Exist().exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'E', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCESEEEFS"));
    }
}
