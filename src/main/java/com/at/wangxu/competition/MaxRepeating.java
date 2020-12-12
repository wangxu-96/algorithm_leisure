package com.at.wangxu.competition;

/**
 * 5557. 最大重复子字符串
 */
public class MaxRepeating {

    public int maxRepeating(String sequence, String word) {
        int count = 0;
        String tempString = word;
        while (sequence.indexOf(word) != - 1) {
            count ++;
            word = word + tempString;
        }
        return count;
    }

    public static void main(String[] args) {
        MaxRepeating maxRepeating = new MaxRepeating();
        System.out.println(maxRepeating.maxRepeating("ababc", "ab"));
        System.out.println(maxRepeating.maxRepeating("ababc", "ba"));
        System.out.println(maxRepeating.maxRepeating("ababc", "ac"));
        System.out.println(maxRepeating.maxRepeating("aaa", "a"));
    }
}
