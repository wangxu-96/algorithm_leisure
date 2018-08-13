package com.at.wangxu.job;

public class Singleton {
    private static Singleton singleton=new Singleton();

    private Singleton() {
    }

    public static Singleton getInstance(){
        return singleton;
    }

    public static void main(String[] args){
        Singleton.getInstance();
    }

}
