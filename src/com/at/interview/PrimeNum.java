package com.at.interview;

public class PrimeNum {
    public static void main(String[] args){

        int count=0;
        for (int i = 101; i < 200; i++) {
            boolean flag=true;
            for (int j = 2; j < i/2; j++) {
                if (i % j==0){
                    flag=false;
                    break;
                }
            }
            if (flag){
                System.out.println();
                count++;
            }
        }
        System.out.println(count);
    }
}
