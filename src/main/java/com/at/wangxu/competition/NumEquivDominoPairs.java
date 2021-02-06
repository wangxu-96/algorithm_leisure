package com.at.wangxu.competition;

import com.at.wangxu.leetcode.TupleSameProduct;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

@SuppressWarnings("unused")
public class NumEquivDominoPairs {

    public int numEquivDominoPairs(int[][] dominoes) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int[] domino : dominoes) {
            int x = domino[0];
            int y = domino[1];
            map.put(x * 10 + y, map.getOrDefault(Math.min(x, y) * 10 + Math.max(x, y), 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) continue;
            count += entry.getValue() * (entry.getValue() - 1) / 2;
        }

        return count;
    }
}
