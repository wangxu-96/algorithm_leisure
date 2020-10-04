package com.at.interview;

public class ExchangeBottle {
    public static void main(String[] args){
        System.out.println(getInt(20));
    }
    private static int getInt(int money){
        int sum=0;
        int remain=0;
        while (money!=0){
            sum+=money+remain/2;
            remain=money+remain%2;
            money=money/2;
        }

        return sum;
    }
}
