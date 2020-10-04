package com.at.wangxu.leetcode;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * <p>
 * 所有输入只包含小写字母 a-z 
 */
public class LongestCommonPrefix {

    /**
     * flow
     * flower
     * flight
     * 先找出第一个字符串和第二个字符串的最长公共前缀，然后拿着这个前缀再和第三个字符串去找最长公共前缀，以此类推
     * @param strings strings
     * @return String
     */
    public String longestCommonPrefix1(String[] strings) {
        if (strings ==null || strings.length == 0)
            return "";
        String prefix = strings[0];
        for (int i = 1; i < strings.length; i++) {
            prefix = longestCommonPrefix(prefix,strings[i]);
            if (prefix.length() == 0)
                return "";
        }
        return prefix;
    }

    public String longestCommonPrefix(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (index < length){
            if (str1.charAt(index) == str2.charAt(index)){
                stringBuilder.append(str1.charAt(index++));
            }else {
                return stringBuilder.toString();
            }
        }
        return stringBuilder.toString();
    }

    /**
     * 竖着比较
     * flow
     * flower
     * flight
     *
     * 初始指针都指向第一个元素，依次比较是否相等；
     * 如所有字符串的第一个元素都比较完且相等，则比较第二个元素，以此类推。
     * @param strs strs
     * @return String
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        StringBuilder stringBuilder = new StringBuilder();
        int index = 0;
        int length = strs[0].length();

        while (index < length) {
            char c = strs[0].charAt(index);
            for (int i = 0; i < strs.length; i++) {
                if (index == strs[i].length())
                    return stringBuilder.toString();
                if (c != strs[i].charAt(index))
                    return stringBuilder.toString();
                if (i == strs.length - 1)
                    stringBuilder.append(c);
            }
            index++;
        }
        return stringBuilder.toString();
    }






    public static void main(String[] args) {
        LongestCommonPrefix commonPrefix = new LongestCommonPrefix();
        System.out.println(commonPrefix.longestCommonPrefix1(new String[]{"flower", "flow", "flowht"}));
        System.out.println(commonPrefix.longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
    }
}
