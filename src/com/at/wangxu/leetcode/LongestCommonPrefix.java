package com.at.wangxu.leetcode;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 *
 * 所有输入只包含小写字母 a-z 
 *
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        StringBuilder result = new StringBuilder();

        int length = Integer.MAX_VALUE;
        for (String str : strs) {
            length = Math.min(length, str.length());
        }

        //初始指针
        int index = 0;
        while (index < length) {
            char c = strs[0].charAt(index);
            for (int i = 0; i < strs.length; i++) {
                if (c != strs[i].charAt(index))
                    return result.toString();
                if (i == strs.length - 1)
                    result.append(c);
            }
            index++;
        }
        return result.toString();
    }

    public static void main(String[] args) {
        LongestCommonPrefix commonPrefix = new LongestCommonPrefix();
        System.out.println(commonPrefix.longestCommonPrefix(new String[]{"flower","flow","flight"}));
        System.out.println(commonPrefix.longestCommonPrefix(new String[]{"dog","racecar","car"}));
        System.out.println(commonPrefix.longestCommonPrefix(new String[]{}));
    }
}
