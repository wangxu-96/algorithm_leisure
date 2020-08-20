package com.at.wangxu.newcoder;

/**
 * 在一个二维数组中（每个一维数组的长度相同），
 * 每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * <p>
 * {1,2,3}
 * {4,5,6}
 * {7,8,9}
 */
public class Find {

    int[][] visited;
    int row;
    int column;
    boolean isExist = false;

    public boolean Find(int target, int[][] array) {
        if (array.length == 0 || array[0].length == 0)
            return false;
        row = array.length;
        column = array[0].length;
        visited = new int[row][column];
        dfs(array, target, row - 1, 0);
        return isExist;
    }

    public void dfs(int[][] array, int target, int x, int y) {
        if (x < 0 || x >= row || y < 0 || y >= column || visited[x][y] == 1 || isExist)
            return;
        visited[x][y] = 1;
        if (array[x][y] == target)
            isExist = true;
        else if (array[x][y] < target) {
            dfs(array, target, x + 1, y);
            dfs(array, target, x, y + 1);
        } else {
            dfs(array, target, x - 1, y);
            dfs(array, target, x, y - 1);
        }
    }

    public static void main(String[] args) {
        Find find = new Find();
        System.out.println(find.Find(4, new int[][]{{1,2,3},{4,5,6},{7,8,9}}));
    }
}
