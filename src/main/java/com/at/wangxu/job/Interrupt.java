package com.at.wangxu.job;

public class Interrupt {

    public static void main(String[] args) {
        Runnable target = Interrupt::run;
        Thread thread = new Thread(target);
        thread.start();
        thread.interrupt();
    }

    private static void run() {
        try {
            System.out.println("sleep start ");
            Thread.sleep(2000);
            System.out.println("sleep done ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
