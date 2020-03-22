package com.at.wangxu.leetcode;

/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 */
public class ReplaceSpace {

    public String replaceSpace(String s) {
        /*StringBuilder stringBuilder = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ' '){
                stringBuilder.append("%20");
                continue;
            }
            stringBuilder.append(c);
        }
        return stringBuilder.toString();*/

        return s.replace(" ","%20");
    }


    public static void main(String[] args) {
        System.out.println(new ReplaceSpace().replaceSpace("We are happy."));
    }
}
