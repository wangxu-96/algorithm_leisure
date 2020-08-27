package com.at.wangxu.leetcode;

/**
 * 459. 重复的子字符串
 * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abab"
 * <p>
 * 输出: True
 * <p>
 * 解释: 可由子字符串 "ab" 重复两次构成。
 * 示例 2:
 * <p>
 * 输入: "aba"
 * <p>
 * 输出: False
 * 示例 3:
 * <p>
 * 输入: "abcabcabcabc"
 * <p>
 * 输出: True
 * <p>
 * 解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
 */
public class RepeatedSubstringPattern {

    private boolean flag = false;

    public boolean repeatedSubstringPattern(String s) {
        int length = s.length();
        for (int i = 0; i < length / 2 && !flag; i++) {
            if (s.length() % (i + 1) == 0) {//如果s length不是key length的整数倍，则肯定不满足条件
                flag = judgePoint(s.substring(0, i + 1), i, s);
            }
        }
        return flag;
    }

    private boolean judgePoint(String key, int i, String s) {
        if (s.length() - i - 1 < key.length())
            return false;
        if (s.length() - i - 1 == key.length() && s.substring(i + 1).equals(key))
            return true;
        if (s.substring(i + 1).startsWith(key)) {
            return judgePoint(key, i + key.length(), s);
        }
        return false;
    }


    public static void main(String[] args) {
        System.out.println(new RepeatedSubstringPattern().repeatedSubstringPattern("ababab"));
        System.out.println(new RepeatedSubstringPattern().repeatedSubstringPattern("aba"));
        System.out.println(new RepeatedSubstringPattern().repeatedSubstringPattern("abcabcabcabc"));
    }
}
