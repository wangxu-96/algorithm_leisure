package com.at.wangxu.time;


import java.text.SimpleDateFormat;
import java.util.*;

public class TimingTask extends TimerTask{



    private String taskName;

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public TimingTask(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        System.out.println("execute time is"+new SimpleDateFormat("yyyy-MM-ss hh:mm:ss").format(new Date())+taskName);
        try {
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }



    public static void main(String[] args){
        Timer timer=new Timer();
        Calendar calendar=Calendar.getInstance();
        timer.schedule(new TimingTask("timeTask"),calendar.getTime(),1000);
    }
}
