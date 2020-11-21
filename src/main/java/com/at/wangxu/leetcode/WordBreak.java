package com.at.wangxu.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 140. 单词拆分 II
 * 
 * https://leetcode-cn.com/problems/word-break-ii 
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。
 * 返回所有这些可能的句子。
 * 
 * 说明：
 * 
 * 分隔时可以重复使用字典中的单词。 你可以假设字典中没有重复的单词。 示例 1：
 * 
 * 输入: s = "catsanddog" wordDict = ["cat", "cats", "and", "sand", "dog"] 
 * 输出: [ "cats and dog",   "cat sand dog" ]
 * 
 * 示例 2：
 * 
 * 输入: s = "pineapplepenapple" wordDict = ["apple", "pen", "applepen", "pine", "pineapple"] 
 * 输出: [   "pine apple pen apple",   "pineapple pen apple",   "pine applepen apple" ]
 * 
 * 解释: 注意你可以重复使用字典中的单词。 
 * 
 * 示例 3：
 * 
 * 输入: s = "catsandog" wordDict = ["cats", "dog", "sand", "and", "cat"] 输出: []
 */
public class WordBreak {

    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>();
        for (String string : wordDict) {
            dict.add(string);
        }

        int count = (int) Math.pow(2, s.length());

        List<String> list = new ArrayList<>();
        for (int i = 0; i <= count; i++) {
            int temp = i;
            int index = 0;
            StringBuilder copy = new StringBuilder(s);
            StringBuilder stringBuilder = new StringBuilder();
            boolean flag = true;
            while (temp > 0) {
                if ((temp & 1) == 0) {
                    temp >>= 1;
                    index ++;
                }else {
                    if (!dict.contains(copy.substring(0,index))) {
                        flag = false;
                        break;
                    }
                    stringBuilder.append(copy.substring(0,index));
                    copy = new StringBuilder(copy.substring(index));
                }
                index ++;
            }

            if (!flag) continue;

            if (dict.contains(copy.substring(index))) list.add(stringBuilder.toString());

        }

        return list;
    }

    public static void main(String[] args) {
        // System.out.println("catsanddog".substring(0,1));
        WordBreak wordBreak = new WordBreak();
        wordBreak.wordBreak("catsanddog", new ArrayList<>(Arrays.asList("cat", "cats", "and", "sand", "dog"))).forEach(System.out::println);;
        // wordBreak.wordBreak("pineapplepenapple", new ArrayList<>(Arrays.asList("apple", "pen", "applepen", "pine", "pineapple")));
        // wordBreak.wordBreak("catsandog", new ArrayList<>(Arrays.asList("cats", "dog", "sand", "and", "cat")));
    }

}
