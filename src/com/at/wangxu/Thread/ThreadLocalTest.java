package com.at.wangxu.Thread;

public class ThreadLocalTest {
    private ThreadLocal<String> localString=new ThreadLocal<>();
    public static void main(String[] args){
        ThreadLocalTest threadLocalTest=new ThreadLocalTest();
        Runnable runnable=()->{
          threadLocalTest.localString.set("localString in thread: "+Thread.currentThread());
          System.out.println(threadLocalTest.localString.get());
        };
        new Thread(runnable).start();
        new Thread(runnable).start();
    }
}
