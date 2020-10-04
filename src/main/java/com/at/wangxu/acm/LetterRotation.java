package com.at.wangxu.acm;

import java.util.Scanner;

/**
 * 给定两个整数M，N，生成一个M*N的矩阵，矩阵中元素取值为A至Z的26个字母中的一个，A在左上角，其余各数按顺时针方向旋转前进，依次递增放置，当超过26时又从A开始填充。例如，当M=5，N=8时，矩阵中的内容如下：
 *    A   B   C   D   E   F   G   H
 *
 *    V   W   X   Y   Z   A   B   I
 *
 *    U   J   K   L   M   N   C   J
 *
 *    T   I   H   G   F   E   D   K
 *
 *    S   R   Q   P   O   N   M   L
 * 输入描述
 * M为行数，N为列数，其中M，N都为大于0的整数。
 * 输出描述
 * 分行输出相应的结果
 * 输入例子
 * 4 9
 * 输出例子
 *    A   B   C   D   E   F   G   H   I
 *    V   W   X   Y   Z   A   B   C   J
 *    U   J   I   H   G   F   E   D   K
 *    T   S   R   Q   P   O   N   M   L
 */
public class LetterRotation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入行数: ");
        int M = Integer.parseInt(scanner.nextLine());
        System.out.println("请输入列数: ");
        int N = Integer.parseInt(scanner.nextLine());

        char[][] chars = new char[M][N];


        dfs(chars,0,0,3,'A', M, N);

        for (char[] aChar : chars) {
            for (char c : aChar) {
                System.out.print(c + "\t");
            }
            System.out.println();
        }
    }

    /**
     *
     * @param chars chars
     * @param row row
     * @param column column
     * @param direction 0- up,1-down,2-left,3-right
     * @param key key
     * @param M M
     * @param N N
     */
    public static void dfs(char[][] chars,int row,int column,int direction,char key,int M,int N){
        if (row < 0 || row >= M || column <0 || column >= N || chars[row][column] >= 'A')
            return;
        chars[row][column] = key;
        if (key >= 'Z'){
            key = 'A';
        }else {
            key ++;
        }

        if (direction == 0){
            dfs(chars, row - 1, column, 0,key,M,N);
            dfs(chars, row , column+1, 3,key,M,N);
            dfs(chars, row + 1, column, 1,key,M,N);
            dfs(chars, row, column - 1, 2,key,M,N);
        }else if (direction == 1){
            dfs(chars, row + 1, column, 1,key,M,N);
            dfs(chars, row , column+1, 3,key,M,N);
            dfs(chars, row, column - 1, 2,key,M,N);
            dfs(chars, row - 1, column, 0,key,M,N);
        }else if (direction == 2){
            dfs(chars, row, column - 1, 2,key,M,N);
            dfs(chars, row , column+1, 3,key,M,N);
            dfs(chars, row + 1, column, 1,key,M,N);
            dfs(chars, row - 1, column, 0,key,M,N);
        }else if (direction == 3){
            dfs(chars, row , column+1, 3,key,M,N);
            dfs(chars, row + 1, column, 1,key,M,N);
            dfs(chars, row, column - 1, 2,key,M,N);
            dfs(chars, row - 1, column, 0,key,M,N);
        }
    }


}
