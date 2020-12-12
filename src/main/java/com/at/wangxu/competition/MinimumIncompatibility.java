package com.at.wangxu.competition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 5619. 最小不兼容性
 */
public class MinimumIncompatibility {
    int n ;
    public int minimumIncompatibility(int[] nums, int k) {
        n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        List<Integer> nList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            nList.add(nums[i]);
        }
        dfs(res, new ArrayList<Integer>(), nList);
        for (int i = 0; i < res.size(); i++) {
            
            res.get(i);
        }
        return 0;
    }

    public void dfs(List<List<Integer>> res, List<Integer> curr, List<Integer> all) {
        if (curr.size() == n) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int i = 0; i < all.size(); i++) {
            int removed = all.remove(i);
            curr.add(removed);

            dfs(res, curr, all);

            all.add(removed);
            curr.remove(removed);
        }
    }

    public static void main(String[] args) {
        MinimumIncompatibility incompatibility = new MinimumIncompatibility();
        // System.out.println(incompatibility.minimumIncompatibility(new int[] { 1, 2, 1, 4 }, 2));
        System.out.println(incompatibility.minimumIncompatibility(new int[] { 6, 3, 8, 1, 3, 1, 2, 2 }, 4));
        // System.out.println(incompatibility.minimumIncompatibility(new int[] { 5, 3, 3, 6, 3, 3 }, 3));
    }
}
