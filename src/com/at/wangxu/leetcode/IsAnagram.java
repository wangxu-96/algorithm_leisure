package com.at.wangxu.leetcode;

import java.util.Arrays;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * <p>
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * <p>
 * 输入: s = "rat", t = "car"
 * 输出: false
 * <p>
 * 说明:
 * 你可以假设字符串只包含小写字母。
 */
public class IsAnagram {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        int[] count = new int[26];
//        for (int i = 0; i < s.toCharArray().length; i++) {
//            count[s.charAt(i) - 'a']++;
//            count[t.charAt(i) - 'a']--;
//        }

        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            count[c - 'a']--;
        }
        for (int i : count) {
            if (i != 0)
                return false;
        }

//        return Arrays.stream(count).noneMatch(num -> num != 0);
        return true;
    }

    public static void main(String[] args) {
        IsAnagram anagram = new IsAnagram();
        long startTime = System.currentTimeMillis();
        System.out.println(anagram.isAnagram("anagram", "nagaram"));
        System.out.println(anagram.isAnagram("rat", "car"));
        System.out.println("cost time: " + (System.currentTimeMillis() - startTime));
    }
}
