package com.at.wangxu.job;

public class BatchThread {
    public static void main(String[] args){
        new Thread(()->{
            while (true){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("-----");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("*****");
            }
        },"schedule-main").start();


    }
}