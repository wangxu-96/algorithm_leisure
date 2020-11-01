package com.at.wangxu.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * 77. 组合
 * 
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * 
 * 示例:
 * 
 * 输入: n = 4, k = 2 输出: [ [2,4], [3,4], [2,3], [1,2], [1,3], [1,4], ]
 */
public class Combine {


    int size;

    public List<List<Integer>> combine(int n, int k) {
        if (n < k)
            return null;
        List<List<Integer>> list = new ArrayList<>();

        List<Integer> param = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            param.add(i);
        }

        if (n == k) {
            list.add(param);
            return list;
        }

        size = n;

        dfs(list,0, new ArrayDeque<>(k), param, k);

        return list;
    }

    private void dfs(List<List<Integer>> list, int start,ArrayDeque<Integer> current, List<Integer> param, int k) {

        if (k == 0) {
            list.add(new ArrayList<>(current));
            return;
        }

        if(size - start - 1 < k) {
            return;
        }

        int s = param.size();
        for (int i = start ; i < s; i++) {
            int remove = param.remove(i);

            current.addLast(remove);

            dfs(list, i,current, param, k - 1);

            param.add(i, remove);
            current.removeLast();
        }
    }

    public static void main(String[] args) {
        Combine combine = new Combine();
        List<List<Integer>> list = combine.combine(4, 2);
        for (List<Integer> list2 : list) {
            for (int i : list2) {
                System.out.print(i);
            }
            System.out.println();
        }
    }
}
