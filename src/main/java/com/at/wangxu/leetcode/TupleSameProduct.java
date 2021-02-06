package com.at.wangxu.leetcode;

import java.util.*;

@SuppressWarnings("unused")
public class TupleSameProduct {

    static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int tupleSameProduct(int[] nums) {
        Map<Integer, List<Node>> map = new HashMap<>();

        for(int i = 0; i < nums.length - 1; i ++) {
            for(int j = i + 1; j < nums.length; j++) {
                int x = nums[i];
                int y = nums[j];
                int product = x * y;
                map.computeIfAbsent(product,key -> new LinkedList<>()).add(new Node(x, y));
            }
        }
        int res = 0;
        for (Map.Entry<Integer, List<Node>> entry : map.entrySet()) {
            List<Node> value = entry.getValue();
            int size = value.size();
            if (size < 2) continue;
            res += size * (size - 1) / 2 * 8;
        }
        return res;
    }
}
