package com.at.interview;

public class JoinTest {
    public static void main(String[] args){
        new Thread(()->{

            try {
                new Thread(()->{
                System.out.println("2");
                }).join();
                System.out.println("1");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

}
