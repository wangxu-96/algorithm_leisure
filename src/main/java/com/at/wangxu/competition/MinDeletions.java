package com.at.wangxu.competition;

import java.util.Arrays;

/**
 * 5562. 字符频次唯一的最小删除次数
 */
public class MinDeletions {

    public int minDeletions(String s) {
        int[] arr= new int[26];
        for (char c : s.toCharArray()) {
            arr[c - 'a'] ++;
        }
        Arrays.sort(arr);
        
        int count = 0;
        int left = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) continue;
            if (left == - 1) left = i;
        }
        int[] a = Arrays.copyOfRange(arr, left, arr.length);

        for (int i = 0; i < a.length - 1; i++) {
             if (a[i] == a[i + 1]) {
                 //找到删除最小的次数
                 int temp = i;
                 while (temp>= 1 && a[temp] - a[temp -1] <= 1) {
                    temp --;
                 }
                 if (temp == 0) {
                     if (a[0] == 0) {
                         count += a[i];
                         a[i] = 0;
                     }else {
                        count += a[i] - a[0] + 1;
                        a[i] = a[0] - 1;
                     }
                 }else {
                    count += a[i] - a[temp] + 1;
                    a[i] = a[temp] - 1;
                 }
                 Arrays.sort(a);
             }  
        }

        return count;
    }

    public static void main(String[] args) {
        MinDeletions deletions = new MinDeletions();

        System.out.println(deletions.minDeletions("aab"));
        System.out.println(deletions.minDeletions("aaabbbcc"));
        System.out.println(deletions.minDeletions("ceabaacb"));
        System.out.println(deletions.minDeletions("accdcdadddbaadbc"));
        System.out.println(deletions.minDeletions("bbcebab"));
        System.out.println(deletions.minDeletions("gagblhlbfjdagcjcccgjmncfleblmgoanoghedggmanoookejcafofbjnonggfjdmaclbikdidoaihoigbjccioijfnjljmbj"));
    }
}
