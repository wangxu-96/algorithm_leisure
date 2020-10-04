package com.at.wangxu.Thread;

public class SleepState {

    public static void main(String[] args) {
        Thread thread = new Thread(()->{
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();

        while (true){
            try {
                Thread.sleep(50);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(thread.getState());

            if (Thread.State.TERMINATED.equals(thread.getState())){
                System.out.println(thread.getState());

                break;
            }
        }
    }
}
