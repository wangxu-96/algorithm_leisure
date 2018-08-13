package com.at.wangxu.sync;

public class WaitSync {
    public static void main(String[] args){
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        try {
                            this.wait();
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                }
        ).start();
    }
}
