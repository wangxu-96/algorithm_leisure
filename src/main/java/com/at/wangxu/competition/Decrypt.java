package com.at.wangxu.competition;

import java.util.Arrays;

/**
 * 5550. 拆炸弹
 */
public class Decrypt {

    public int[] decrypt(int[] code, int k) {
        int[] result = new int[code.length];
        if (k == 0) {
            for (int i = 0; i < code.length; i++) {
                code[i] = 0;
            }
            return code;
        }else if (k > 0 ) {
            for (int i = 0; i < code.length; i++) {
                int temp = k;
                int sum = 0;
                int start = i + 1;
                while (temp -- > 0) {
                    if (start > code.length - 1) start = 0;
                    sum += code[start ++];
                }
                result[i] = sum;
            }
        }else {
            for (int i = 0; i < code.length; i++) {
                int temp = k;
                int sum = 0;
                int start = i - 1;
                while (temp ++ < 0) {
                    if (start < 0) start = code.length - 1;
                    sum += code[start --];
                }
                result[i] = sum;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Decrypt decrypt = new Decrypt();
        // Arrays.stream(decrypt.decrypt(new int[]{5,7,1,4}, 3)).forEach(System.out::println);;
        // Arrays.stream(decrypt.decrypt(new int[]{1,2,3,4}, 0)).forEach(System.out::println);;
        Arrays.stream(decrypt.decrypt(new int[]{2,4,9,3}, -2)).forEach(System.out::println);;
    }
}
