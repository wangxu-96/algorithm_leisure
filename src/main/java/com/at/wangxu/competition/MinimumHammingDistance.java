package com.at.wangxu.competition;

import java.util.*;

public class MinimumHammingDistance {
    static class UnionFind {
        private int count;
        private final int[] parent;

        public UnionFind(int n) {
            count = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int p) {
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) return;
            parent[rootP] = rootQ;
            count--;
        }
    }

    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        UnionFind unionFind = new UnionFind(n);
        for (int[] allowedSwap : allowedSwaps) {
            unionFind.union(allowedSwap[0],allowedSwap[1]);
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < source.length; i++) {
            int find = unionFind.find(i);
            if (map.containsKey(find)) {
                map.get(find).add(i);
            }else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(find, list);
            }
        }
        int res = 0;
        for (Map.Entry<Integer, List<Integer>> integerListEntry : map.entrySet()) {
            List<Integer> value = integerListEntry.getValue();

            Map<Integer, Integer> sourceMap = new HashMap<>();
            Map<Integer, Integer> targetMap = new HashMap<>();

            for (Integer integer : value) {
                sourceMap.put(source[integer],sourceMap.getOrDefault(source[integer],0) + 1);
                targetMap.put(target[integer],targetMap.getOrDefault(target[integer],0) + 1);
            }
            for (Map.Entry<Integer, Integer> entry : targetMap.entrySet()) {
                if (sourceMap.containsKey(entry.getKey())) {
                    res += Math.max(0,entry.getValue() - sourceMap.get(entry.getKey()));
                }else {
                    res += entry.getValue();
                }
            }
        }

        return res;
    }


    public static void main(String[] args) {
        System.out.println();
        MinimumHammingDistance distance = new MinimumHammingDistance();
        System.out.println(distance.minimumHammingDistance(new int[]{71,13,6,60,22,31}, new int[]{66,57,2,60,22,73}, new int[][]{{4,5},{0,4}}));
    }
}
