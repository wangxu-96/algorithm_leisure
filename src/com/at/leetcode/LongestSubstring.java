package com.at.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {

    public static void main(String[] args){

        String s = "pwwkew";
        System.out.println("longest substring length is: "+lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s){
        int maxLength = 0;
        int start = 0;
        Map<Character,Integer> map =new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int index = map.get(s.charAt(i)) == null? -1:map.get(s.charAt(i));
            if (index >= start ){
                start = index+1;
            }
            if (i-start+1 > maxLength){
                maxLength =i-start+1;
            }
            map.put(s.charAt(i),i);
        }
        
        return maxLength;
    }
}
