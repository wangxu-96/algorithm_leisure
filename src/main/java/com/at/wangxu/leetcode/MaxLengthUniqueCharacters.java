package com.at.wangxu.leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * 1239. 串联字符串的最大长度
 * 
 * 给定一个字符串数组 arr，字符串 s 是将 arr 某一子序列字符串连接所得的字符串，如果 s 中的每一个字符都只出现过一次，那么它就是一个可行解。
 *
 * 请返回所有可行解 s 中最长长度。
 * 
 * 输入：arr = ["un","iq","ue"] 输出：4 解释：所有可能的串联组合是 "","un","iq","ue","uniq" 和
 * "ique"，最大长度为 4。
 */

public class MaxLengthUniqueCharacters {

    static class Struct {
        long l;// bit
        int s;// size of string

        public Struct(long bit, int size) {
            l = bit;
            s = size;
        }

    }

    public int maxLength(List<String> arr) {
        int n = arr.size();
        Struct[] structs = new Struct[n];
        int effective_index = 0;
        for (String s : arr) {
            char[] chars = s.toCharArray();
            long l = 0;
            for (char c : chars) {
                // duplicate char
                if ((l >> (c - 'a') & 0x1) == 1) {
                    l = 0;
                    break;
                }
                l |= 1 << c - 'a';
            }
            if (l > 0)
                structs[effective_index++] = new Struct(l, chars.length);
        }

        return iterator(structs, effective_index);
    }

    private int iterator(Struct[] structs,int effective_index) {
        int num = 2 << effective_index;
        int start = 0;
        int res = 0;
        while (start <= num) {
            int curr_size = 0;
            long curr_or = 0;
            for (int i = 0; i < effective_index; i++) {
                if ((start & (1 << i)) > 0) {
                    if (curr_or == 0 || (curr_or & structs[i].l) == 0) {
                        curr_size += structs[i].s;
                        curr_or |= structs[i].l;
                    }else {
                        curr_size = 0;
                        break;
                    }
                }
            }
            res = Math.max(res, curr_size);
            start ++;
        }
        return res;
    }

    public static void main(String[] args) {
        MaxLengthUniqueCharacters uniqueCharacters = new MaxLengthUniqueCharacters();
        System.out.println(uniqueCharacters.maxLength(Arrays.asList("un", "iq", "ue")));
        System.out.println(uniqueCharacters.maxLength(Arrays.asList("cha","r","act","ers")));
        System.out.println(uniqueCharacters.maxLength(Arrays.asList("abcdefghijklmnopqrstuvwxyz")));
    }
}