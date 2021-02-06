package com.at.wangxu.leetcode;

import com.at.wangxu.template.UnionFind;

import java.util.*;

public class FindRedundantConnection {

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        UnionFind unionFind = new UnionFind(n + 1);
        for (int[] edge : edges) {
            if (unionFind.find(edge[0]) == unionFind.find(edge[1])) return edge;
            unionFind.union(edge[0],edge[1]);
        }

        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        FindRedundantConnection redundantConnection = new FindRedundantConnection();
        Arrays.stream(redundantConnection.findRedundantConnection(new int[][]{{1, 2}, {1, 3}, {2, 3}})).forEach(System.out::println);
        Arrays.stream(redundantConnection.findRedundantConnection(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}})).forEach(System.out::println);
    }
}
