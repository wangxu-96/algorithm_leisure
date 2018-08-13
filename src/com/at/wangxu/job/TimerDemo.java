package com.at.wangxu.job;

import java.util.Timer;
import java.util.TimerTask;

public class TimerDemo {
    public static void main(String[] args){
        /*Timer timer=new Timer(false);
        TimerTask timerTask=new TimerTask() {
            @Override
            public void run() {
                System.out.println("-----");
            }
        };
        timer.schedule(timerTask,1000,1000);*/
        try {
            int a=10/0;
        }catch (ArithmeticException e){
            e.printStackTrace();
        }
        System.out.println(1);
    }
}
