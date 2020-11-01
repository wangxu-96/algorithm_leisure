package com.at.wangxu.competition;

import java.util.HashMap;
import java.util.Map;

/**
 * 5554. 能否连接形成数组 显示英文描述 
通过的用户数0
尝试过的用户数0
用户总通过次数0
用户总提交次数0
题目难度Easy
给你一个整数数组 arr ，数组中的每个整数 互不相同 。另有一个由整数数组构成的数组 pieces，其中的整数也 互不相同 。请你以 任意顺序 连接 pieces 中的数组以形成 arr 。但是，不允许 对每个数组 pieces[i] 中的整数重新排序。

如果可以连接 pieces 中的数组形成 arr ，返回 true ；否则，返回 false 。

 

示例 1：

输入：arr = [85], pieces = [[85]]
输出：true
示例 2：

输入：arr = [15,88], pieces = [[88],[15]]
输出：true
解释：依次连接 [15] 和 [88]
示例 3：

输入：arr = [49,18,16], pieces = [[16,18,49]]
输出：false
解释：即便数字相符，也不能重新排列 pieces[0]
示例 4：

输入：arr = [91,4,64,78], pieces = [[78],[4,64],[91]]
输出：true
解释：依次连接 [91]、[4,64] 和 [78]
示例 5：

输入：arr = [1,3,5,7], pieces = [[2,4,6,8]]
输出：false
 

提示：

1 <= pieces.length <= arr.length <= 100
sum(pieces[i].length) == arr.length
1 <= pieces[i].length <= arr.length
1 <= arr[i], pieces[i][j] <= 100
arr 中的整数 互不相同
pieces 中的整数 互不相同（也就是说，如果将 pieces 扁平化成一维数组，数组中的所有整数互不相同）
 */
public class CanFormArray {
    

    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer,int[]> map = new HashMap<>();

        for (int[] is : pieces) {
            for (int i : is) {
                map.put(i, is);
            }
        }

        int start = 0;
        int size = arr.length;
        while (start < size) {
            if (!map.containsKey(arr[start])) return false;
            int[] a = map.get(arr[start]);

            for(int k = 0; k < a.length ; k ++) {
                if (a[k] != arr[start]) return false;
                start ++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CanFormArray canFormArray = new CanFormArray();

        System.out.println(canFormArray.canFormArray(new int[]{85}, new int[][]{{85}}));
        System.out.println(canFormArray.canFormArray(new int[]{15,88}, new int[][]{{88},{15}}));
        System.out.println(canFormArray.canFormArray(new int[]{49,18,16}, new int[][]{{16,18,49}}));
        System.out.println(canFormArray.canFormArray(new int[]{91,4,64,78}, new int[][]{{78},{4,64},{91}}));
        System.out.println(canFormArray.canFormArray(new int[]{1,3,5,7}, new int[][]{{2,4,6,8}}));
    }
}
