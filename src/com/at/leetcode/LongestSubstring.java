package com.at.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 最长不重复子串
 */
public class LongestSubstring {
    public static void main(String[] args){
        System.out.println(longestLength("distinct"));
    }

    private static int longestLength(String s){
        Map<Character ,Integer> lastOccurred=new HashMap();
        int maxLength=0;
        int start=0;
        for (int i = 0; i < s.length(); i++) {
            int index=lastOccurred.get(s.charAt(i))==null?-1:lastOccurred.get(s.charAt(i));
            if (index>=start){
                start=index+1;
            }
            if (i-start+1>maxLength){
                maxLength=i-start+1;
            }

            lastOccurred.put(s.charAt(i),i);
        }
        return maxLength;
    }
}
