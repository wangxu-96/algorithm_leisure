package com.at.wangxu.job;

public class CanChangeString {
    public  static void main(String[] args){
        changeStr(1,"1","2","3","4","5");
    }

    public static void changeStr(int i,String... keys){
        for (int j = 0; j <keys.length ; j++) {
            System.out.println(keys[j]);
        }
    }
}
