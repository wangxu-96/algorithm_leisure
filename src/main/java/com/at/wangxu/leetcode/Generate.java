package com.at.wangxu.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. 杨辉三角 https://leetcode-cn.com/problems/pascals-triangle/
 */
public class Generate {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < numRows; ++i) {
            List<Integer> curr = new ArrayList<>();
            for (int j = 0; j <= i; ++j) {
                if (j == 0 || j == i) {
                    curr.add(1);
                    continue;
                }
                curr.add(list.get(i - 1).get(j - 1) + list.get(i - 1).get(j));
            }
            list.add(new ArrayList<>(curr));
        }

        return list;
    }

    public static void main(String[] args) {
        Generate generate = new Generate();
        generate.generate(5);
    }
}
