package com.at.wangxu.leetcode;

import java.util.HashMap;
import java.util.Map;

public class NoRepatingString {

    public static void main(String[] args) {
        System.out.println(findMaxLength("pwwkew"));
    }

    public static String findMaxLength(String string) {
        String result = "";
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int currentMaxLength = 0;
        int start = 0;
        for (int i = 0; i < string.length(); i++) {
            int a = (map.get(string.charAt(i)) == null ? 0 : map.get(string.charAt(i)));
            if (a >= start) {//拆箱空指针
                start = a + 1;
            }
            if (i - start + 1 > currentMaxLength) {
                currentMaxLength = i - start + 1;
            }
            map.put(string.charAt(i), i);
        }
        return result;
    }
}
