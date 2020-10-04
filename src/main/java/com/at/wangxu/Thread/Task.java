package com.at.wangxu.Thread;

import java.time.LocalTime;

public class Task implements Runnable {
    private int id;

    public Task(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println(LocalTime.now()+"当前线程id和名称为:"+this.id);
        try {
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                '}';
    }
}
