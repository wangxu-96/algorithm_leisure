package com.at.wangxu.leetcode;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 */
public class IsValid {

    public boolean isValid(String s) {

        if (s == null || s.length() == 0)
            return true;

        int length = s.length();
        int index = 0;
        Stack<Character> stack = new Stack<>();
        while (index < length) {
            if (s.charAt(index) == '(' || s.charAt(index) == '[' || s.charAt(index) == '{')
                stack.push(s.charAt(index));
            else {
                if (stack.isEmpty()){
                    return false;
                }
                if (s.charAt(index) == ')' && stack.pop() != '(') {
                    return false;
                }
                if (s.charAt(index) == ']' && stack.pop() != '[') {
                    return false;
                }
                if (s.charAt(index) == '}' && stack.pop() != '{') {
                    return false;
                }
            }
            index++;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        IsValid valid = new IsValid();
        System.out.println(valid.isValid("()"));
        System.out.println(valid.isValid("()[]{}"));
        System.out.println(valid.isValid("(]"));
        System.out.println(valid.isValid("([)]"));
        System.out.println(valid.isValid("{[]}"));
        System.out.println(valid.isValid("["));
        System.out.println(valid.isValid("]"));
    }
}
