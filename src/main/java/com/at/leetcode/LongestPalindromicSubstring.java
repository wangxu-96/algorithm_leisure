package com.at.leetcode;

/**
 * Leetcode 5 Longest Palindromic Substring
 *
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000
 */
public class LongestPalindromicSubstring {

    private static int start,maxLength;//leetcode cannot set static field

    public String longestPalindrome(String s){
        if (s.length()<2)
            return s;
        for (int i = 0; i < s.length()-1; i++) {
            getLength(s,i,i);
            getLength(s,i,i+1);
        }
        return s.substring(start,start+maxLength);
    }


    private void getLength(String s, int l,int r){
        while (l>=0 && r<=s.length()-1 && s.charAt(l) == s.charAt(r)){
            l -- ;
            r ++;
        }
        if (maxLength < r-l -1){
            start = l+1;
            maxLength = r-l-1;
        }
    }

    public static void main(String[] args){
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("ac"));
    }
}
