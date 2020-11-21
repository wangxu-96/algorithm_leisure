package com.at.wangxu.competition;

import java.util.Arrays;

public class CloseStrings {

    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) return false;
        char[] char1 = word1.toCharArray();
        int[] ints1 = new int[26];
        for (int i = 0; i < char1.length; i++) {
            ints1[char1[i] - 'a'] ++;
        }
        int[] ints2 = new int[26];
        char[] char2 = word2.toCharArray();
        for (int i = 0; i < char2.length; i++) {
            ints2[char2[i] - 'a'] ++;
        }
        int start = 0;
        while (start < 26) {
            if (ints1[start] == 0 && ints2[start] != 0 ) return false;
            if (ints1[start] != 0 && ints2[start] == 0 ) return false;
            start ++;
        }

        Arrays.sort(ints1);
        Arrays.sort(ints2);
        int left = -1;
        for (int i = 0; i < ints1.length; i++) {
            if (ints1[i] > 0 ) {
                left = i;
                break;
            }
        }

        int right = -1;
        for (int i = 0; i < ints2.length; i++) {
            if (ints2[i] > 0 ) {
                right = i;
                break;
            }
        }

        if (left != right) return false;
        while (left < ints1.length) {
            if (ints1[left ++] == ints2[right ++]) continue;
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        CloseStrings closeStrings = new CloseStrings();
        System.out.println(closeStrings.closeStrings("abc", "bca"));
        System.out.println(closeStrings.closeStrings("a", "aa"));
        System.out.println(closeStrings.closeStrings("cabbba", "abbccc"));
        System.out.println(closeStrings.closeStrings("cabbba", "aabbss"));
        System.out.println(closeStrings.closeStrings("uau", "ssx"));
    }
}
