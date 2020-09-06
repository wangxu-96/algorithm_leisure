package com.at.wangxu.leetcode;

import java.util.*;

/**
 * 60. 第k个排列
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 * <p>
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 * <p>
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 * <p>
 * 说明：
 * <p>
 * 给定 n 的范围是 [1, 9]。
 * 给定 k 的范围是[1,  n!]。
 * 示例 1:
 * <p>
 * 输入: n = 3, k = 3
 * 输出: "213"
 * 示例 2:
 * <p>
 * 输入: n = 4, k = 9
 * 输出: "2314"
 */
public class GetPermutation {
    public String getPermutation(int n, int k) {
        StringBuilder stringBuilder = new StringBuilder();
        int[] ints = new int[n + 1];
        StringBuilder sort = new StringBuilder();

        int sum = 1;
        ints[0] = 1;

        for (int i = 1; i <= n; i++) {
            sort.append(i);
            sum *= i;
            ints[i] = sum;
        }

        int index = 1;
        while (index <= n) {
            if (n == index) {
                stringBuilder.append(sort.charAt(0));
                break;
            }
            if (k == 0){
                stringBuilder.append(sort.reverse());
                break;
            }

            int i = k / ints[n - index];//从数组中取第i个
            int mod = k % ints[n - index];
            if (mod > 0 || i == 0)
                i++;

            stringBuilder.append(sort.charAt(i - 1));
            sort.deleteCharAt(i - 1);
            index++;
            k = mod;
        }
        return stringBuilder.toString();
    }


    public String getPermutationOfficial(int n, int k) {
        int[] permutationNum = new int[n + 1]; // 存放 i 个数有多少种排列
        permutationNum[0] = 1;
        StringBuilder sortChars = new StringBuilder(); // 初始化为递增的排列，然后依次删掉用过的字符
        for (int i = 1; i < n + 1; i++) {
            permutationNum[i] = permutationNum[i - 1] * i;
            sortChars.append(i);
        }
        StringBuilder result = new StringBuilder();
        // 循环计算第j个位置应该填放哪个字符
        int index = k - 1;
        for (int i = n - 1; i >= 1; i--) {
            int select = index / permutationNum[i];
            result.append(sortChars.charAt(select));
            index %= permutationNum[i];
            sortChars.deleteCharAt(select);
        }
        result.append(sortChars.charAt(0));

        return result.toString();
    }

//    public void get(int n, int index, int k, int[] ints, List<Integer> list) {
//        if (n == index) {
//            stringBuilder.append(list.get(0));
//            return;
//        }
//        if (k == 0) {
//            for (int i = list.size() - 1; i >= 0 ; i--) {
//                stringBuilder.append(list.get(i));
//            }
//            return;
//        }
//
//        if (k == 1) {
//            for (Integer integer : list) {
//                stringBuilder.append(integer);
//            }
//            return;
//        }
//
//        int i = k / ints[n - index];//从数组中取第i个
//        int mod = k % ints[n - index];
//        if (mod > 0)
//            i++;
//
//        stringBuilder.append(list.remove(i-1));
//        get(n, index + 1, mod, ints, list);
//    }

    public void factorial(int n, int[] ints) {
        int sum = 1;
        ints[0] = 1;
        for (int i = 1; i <= n; i++) {
            sum *= i;
            ints[i] = sum;
        }
    }

    public static void main(String[] args) {
        System.out.println(new GetPermutation().getPermutation(3, 2));
        System.out.println(new GetPermutation().getPermutation(3, 3));
        System.out.println(new GetPermutation().getPermutation(4, 9));
    }
}
