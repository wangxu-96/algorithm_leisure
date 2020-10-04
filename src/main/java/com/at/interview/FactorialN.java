package com.at.interview;

import java.util.Scanner;

/**
 * n的阶乘后面有多少个0
 */
public class FactorialN {
    public static void main(String[] args){
        System.out.println("请输入数字n:");
        Scanner scanner=new Scanner(System.in);
        int input=scanner.nextInt();
        int count=0;
        while (true){
            input=input/5;
            if (input==0){
                break;
            }else {
                count+=input;
            }
        }
        System.out.println("n阶乘后0的个数为："+count);
        scanner.close();
    }
}
