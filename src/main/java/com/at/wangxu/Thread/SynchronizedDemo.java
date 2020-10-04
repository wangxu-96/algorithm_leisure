package com.at.wangxu.Thread;

public class SynchronizedDemo {

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(()->{
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    System.out.println("-------");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
            }
        });

        thread.start();

        thread.sleep(1000);

        thread.interrupt();



    }

}
