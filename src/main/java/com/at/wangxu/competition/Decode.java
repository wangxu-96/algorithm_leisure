package com.at.wangxu.competition;

import java.util.Arrays;

public class Decode {

    public int[] decode(int[] encoded) {
        int[] result = new int[encoded.length + 1];


        return result;
    }

    public static void main(String[] args) {
        int n = 4;
        for (int i = 1; i < n ; i++) {
            System.out.println(i ^ (i + 1));
        }

        Decode decode = new Decode();
//        Arrays.stream(decode.decode(new int[]{3, 1})).forEach(System.out::println);
//        Arrays.stream(decode.decode(new int[]{6, 5, 4, 6})).forEach(System.out::println);
        //Arrays.stream(decode.decode(new int[]{12, 6, 11, 10, 5, 3, 4, 6})).forEach(System.out::println);
    }
}
