package com.at.wangxu.Thread;

public class VolatileDemo {
    private static  boolean isOver=false;
    public static void main(String[] args){
        Thread thread=new Thread(()->{
            while (!isOver);
        });
        thread.start();
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        isOver=true;
    }
}
