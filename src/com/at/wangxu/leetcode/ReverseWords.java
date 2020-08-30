package com.at.wangxu.leetcode;

import java.util.Stack;

/**
 * 557. 反转字符串中的单词 III
 * <p>
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * <p>
 * 示例：
 * <p>
 * 输入："Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc"
 *  
 * <p>
 * 提示：
 * <p>
 * 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 */
public class ReverseWords {

    public String reverseWords(String s) {
        int index = s.indexOf(" ");
        if (index == -1)
            return new StringBuffer(s).reverse().toString();
        return new StringBuffer(s.substring(0, index)).reverse()
                .append(" ").append(reverseWords(s.substring(index + 1))).toString();
    }

    public String reverseWordsI(String s) {
        StringBuilder stringBuilder = new StringBuilder();

        int index = 0;
        int length = s.length();

        Stack<Character> stack = new Stack<>();

        while (index < length) {
            if (s.charAt(index) == ' ') {
                while (!stack.isEmpty()) {
                    stringBuilder.append(stack.pop());
                }
                stringBuilder.append(" ");
            } else {
                stack.push(s.charAt(index));
                if (index == length - 1) {
                    while (!stack.isEmpty()) {
                        stringBuilder.append(stack.pop());
                    }
                }
            }
            index++;
        }
        return stringBuilder.toString();
    }

    public String reverseWordsOfficial(String s) {
        StringBuilder ret = new StringBuilder();
        int length = s.length();
        int i = 0;
        while (i < length) {
            int start = i;
            while (i < length && s.charAt(i) != ' ') {
                i++;
            }
            for (int p = start; p < i; p++) {
                ret.append(s.charAt(start + i - 1 - p));
            }
            while (i < length && s.charAt(i) == ' ') {
                i++;
                ret.append(' ');
            }
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        System.out.println(new ReverseWords().reverseWords("Let's take LeetCode contest"));
        System.out.println(new ReverseWords().reverseWordsI("Let's take LeetCode contest"));
    }
}
