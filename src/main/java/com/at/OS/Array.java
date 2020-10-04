package com.at.OS;

public class Array {

    static void copyij(int[][] src, int[][] dst) {
        for (int i = 0; i < 2048; i++) {
            for (int j = 0; j < 2048; j++) {
                src[i][j] = dst[i][j];
            }
        }
    }

    static void  copyji(int[][] src, int[][] dst) {
        for (int j = 0; j < 2048; j++) {
            for (int i = 0; i < 2048; i++) {

                src[i][j] = dst[i][j];
            }
        }
    }

    static int[][] buildArr(){
        int[][] arr = new int[2048][2048];
        for (int i = 0; i < 2048; i++) {
            for (int j = 0; j < 2048; j++) {
                arr[i][j] = 0;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[][] ints = buildArr();
        int[][] ints2 = buildArr();
        long start = System.currentTimeMillis();
        copyij(ints, ints2);
        System.out.println("i ->j cost time" + (System.currentTimeMillis() - start));


        int[][] ints3 = buildArr();
        int[][] ints4 = buildArr();
        long start1 = System.currentTimeMillis();
        copyji(ints3, ints4);
        System.out.println("j ->i cost time" + (System.currentTimeMillis() - start1));

    }
}
