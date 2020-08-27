package com.at.wangxu.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 491. 递增子序列
 * 给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。
 * <p>
 * 示例:
 * <p>
 * 输入: [4, 6, 7, 7]
 * 输出: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
 * 说明:
 * <p>
 * 给定数组的长度不会超过15。
 * 数组中的整数范围是 [-100,100]。
 * 给定数组中可能包含重复数字，相等的数字应该被视为递增的一种情况。
 */
public class FindSubsequences {

    List<Integer> temp = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    Set<Integer> set = new HashSet<>();
    int n;

    public List<List<Integer>> findSubsequences(int[] nums) {
        n = nums.length;
        for (int i = 0; i < (1 << n); ++i) {
            findSubsequences(i, nums);
            int hashValue = getHash(263, (int) 1E9 + 7);
            if (check() && !set.contains(hashValue)) {
                ans.add(new ArrayList<Integer>(temp));
                set.add(hashValue);
            }
        }
        return ans;
    }

    public void findSubsequences(int mask, int[] nums) {
        temp.clear();
        for (int i = 0; i < n; ++i) {
            if ((mask & 1) != 0) {
                temp.add(nums[i]);
            }
            mask >>= 1;
        }
    }

    public int getHash(int base, int mod) {
        int hashValue = 0;
        for (int x : temp) {
            hashValue = hashValue * base % mod + (x + 101);
            hashValue %= mod;
        }
        return hashValue;
    }

    public boolean check() {
        for (int i = 1; i < temp.size(); ++i) {
            if (temp.get(i) < temp.get(i - 1)) {
                return false;
            }
        }
        return temp.size() >= 2;
    }

    public int getHash1(List<Integer> list) {
        int base = 263;
        int mod = (int) 1E9 + 7;
        int hashValue = 0;
        for (int x : list) {
            hashValue = hashValue * base % mod + (x + 101);
            hashValue %= mod;
        }
        return hashValue;
    }

    public List<List<Integer>> findSubsequences1(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] <= nums[j] && !set.contains(nums[j])) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    set.add(nums[j]);
                    lists.add(list);
                }
            }
        }
        for (int i = 0; i < lists.size(); i++) {
            List<Integer> list = lists.get(i);
            Integer tail = list.get(list.size() - 1);
            Set<Integer> set = new HashSet<>();
            for (int j = tail + 1; j < nums.length; j++) {
                if (nums[tail] <= nums[j] && !set.contains(nums[j])) {
                    List<Integer> list1 = new ArrayList<>(list);
                    list1.add(j);
                    set.add(nums[j]);
                    lists.add(list1);
                }
            }
        }

        List<List<Integer>> result = new ArrayList<>();

        for (List<Integer> list : lists) {
            List<Integer> temp = new ArrayList<>();
            for (Integer integer : list) {
                temp.add(nums[integer]);
            }
            result.add(temp);
        }

        //去重
        List<List<Integer>> lists1 = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (List<Integer> list : result) {
            int hash1 = getHash1(list);
            if (!set.contains(hash1)) {
                lists1.add(list);
                set.add(hash1);
            }
        }
        return lists1;
    }

    public static void main(String[] args) {
        List<List<Integer>> subsequences = new FindSubsequences().findSubsequences(new int[]{1,2,3,4,5,6,7,8,9,10,1,1,1,1,1});

        for (List<Integer> subsequence : subsequences) {
            subsequence.forEach(System.out::print);
            System.out.println();
        }
    }
}
