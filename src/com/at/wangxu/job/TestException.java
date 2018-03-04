package com.at.wangxu.job;

import java.util.HashMap;

public class TestException {



    public static void main(String[] args) throws Exception{
        int a=10;
        int b=0;
        int c;
try {


    try {
        se(a, b);
    } catch (Exception e) {
        System.out.println("1-------");
        throw new Exception();
    }
}catch (Exception e){
    System.out.println("11111");
}
        try {
            System.out.println("222");
            c=a/b;
        }catch (Exception e){
            System.out.println("2-------");
        }

    }

    private static void se(int a,int b){

        int c=a/b;
    }


}
