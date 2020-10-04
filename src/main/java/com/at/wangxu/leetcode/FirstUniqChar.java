package com.at.wangxu.leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 387. 字符串中的第一个唯一字符
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 *  
 *
 * 示例：
 *
 * s = "leetcode"
 * 返回 0
 *
 * s = "loveleetcode"
 * 返回 2
 *  
 *
 * 提示：你可以假定该字符串只包含小写字母。
 *
 */
public class FirstUniqChar {

    public int firstUniqChar(String s) {

        HashMap<Character, Integer> count = new HashMap<Character, Integer>();
        int n = s.length();
        // build hash map : character and how often it appears
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        // find the index
        for (int i = 0; i < n; i++) {
            if (count.get(s.charAt(i)) == 1)
                return i;
        }
        return -1;
    }

    public int firstUniqChar1(String s) {

        int res = -1;
        for (char ch = 'a'; ch <= 'z'; ch++) {
            int index = s.indexOf(ch);
            if (index != -1 && index == s.lastIndexOf(ch)) {
                res = res == -1 ? index : Math.min(res, index);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new FirstUniqChar().firstUniqChar1("leetcode"));
        System.out.println(new FirstUniqChar().firstUniqChar1("loveleetcode"));
        System.out.println(new FirstUniqChar().firstUniqChar1("cc"));
    }
}
