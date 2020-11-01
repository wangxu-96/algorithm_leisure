package com.at.wangxu.competition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 5600. 第 K 条最小指令
 * 
 * Bob 站在单元格 (0, 0) ，想要前往目的地 destination ：(row, column) 。他只能向 右 或向 下 走。你可以为 Bob
 * 提供导航 指令 来帮助他到达目的地 destination 。
 * 
 * 指令 用字符串表示，其中每个字符：
 * 
 * 'H' ，意味着水平向右移动 'V' ，意味着竖直向下移动 能够为 Bob 导航到目的地 destination 的指令可以有多种，
 * 例如，如果目的地
 * destination 是 (2, 3)，"HHHVV" 和 "HVHVH" 都是有效 指令 。
 * 
 * 然而，Bob 很挑剔。因为他的幸运数字是 k，他想要遵循 按字典序排列后的第 k 条最小指令 的导航前往目的地 destination 。k 的编号 从
 * 1 开始 。
 * 
 * 给你一个整数数组 destination 和一个整数 k ，请你返回可以为 Bob 提供前往目的地 destination 导航的 按字典序排列后的第 k
 * 条最小指令 。
 * 示例 1：
 * 
 * 输入：destination = [2,3], k = 1 输出："HHHVV" 
 * 解释：能前往 (2, 3) 的所有导航指令 按字典序排列后 如下所示：
 * ["HHHVV", "HHVHV", "HHVVH", "HVHHV", "HVHVH", "HVVHH", "VHHHV", "VHHVH",
 * "VHVHH", "VVHHH"].
 * 
 *  示例 2：
 * 输入：destination = [2,3], k = 2 输出："HHVHV" 
 * 
 * 示例 3：
 * 输入：destination = [2,3], k = 3 输出："HHVVH"
 * 
 * 提示：
 * 
 * destination.length == 2 1 <= row, column <= 15 1 <= k <= nCr(row + column,row)，其中 nCr(a, b) 表示组合数，
 * 即从 a 个物品中选 b 个物品的不同方案数。
 */
public class KthSmallestPath {

    List<String> list = new ArrayList<>();
    int l;

    /**
     * dfs 解法，先把所有的路径保存起来，在取出最后一个
     * 时间复杂度较高，无法AC
     * @param destination destination
     * @param k k
     * @return String
     */
    public String kthSmallestPath(int[] destination, int k) {
        l = k;

        int[][] arr = new int[destination[0] + 1][destination[1] + 1];
        int row = arr.length;
        int column = arr[0].length;
        boolean[][] visited = new boolean[arr.length][arr[0].length];

        dfs(arr, visited, 0, 0, row, column, new StringBuilder());
        return list.get(k - 1);
    }

    /**
     * 组合数
     * 
     * @param destination destination
     * @param k k
     * @return String
     */
    
    public String kthSmallestPathAC(int[] destination,int k) {
        int v = destination[0];
        int h = destination[1];

        int[][] comb = new int[v + h ][h + v ];
        
        comb[0][0] = 1;
        for (int i = 1; i < h + v; ++i) {
            comb[i][0] = 1;
            for (int j = 1; j <= i; ++j) {
                comb[i][j] = comb[i - 1][j - 1] + comb[i - 1][j];
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        int start = 0;
        int max = h + v;
        while (start < max ) {
            if (h > 0 ) {
                int o = comb[h - 1 + v][ h - 1];
                if (k > o) {
                    stringBuilder.append("V");
                    v --;
                    k -= o;
                } else {
                    stringBuilder.append("H");
                    h --;
                }
            }else {
                stringBuilder.append("V");
                v --;
            }
            start ++;
        }
        return stringBuilder.toString();
    }


    private void dfs(int[][] arr, boolean[][] visited, int i, int j, int row, int column, StringBuilder sBuilder) {

        if (list.size() == l)
            return;
        if (i >= row || j >= column || visited[i][j])
            return;

        visited[i][j] = true;

        if (i == row - 1 && j == column - 1)
            list.add(sBuilder.toString());

        dfs(arr, visited, i, j + 1, row, column, sBuilder.append("H"));
        sBuilder.deleteCharAt(sBuilder.length() - 1);
        dfs(arr, visited, i + 1, j, row, column, sBuilder.append("V"));
        sBuilder.deleteCharAt(sBuilder.length() - 1);
        visited[i][j] = false;
    }

    public static void main(String[] args) {
        KthSmallestPath smallestPath = new KthSmallestPath();

        System.out.println(smallestPath.kthSmallestPathAC(new int[]{15,15},
        155117520));
    }

}
