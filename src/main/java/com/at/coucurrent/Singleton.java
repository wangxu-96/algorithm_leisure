package com.at.coucurrent;

public class Singleton {
    private static  Singleton singleton;
    private Thread thread;
    private Singleton(Thread thread) {
        this.thread=thread;
    }

    public Thread getThread() {
        return thread;
    }

    public static Singleton getInstance(){
        if (singleton==null){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized(Singleton.class){
                if (singleton==null)
                singleton=new Singleton(Thread.currentThread());
            }
        }
        return singleton;
    }
}
class TestMain{
    public static void main(String[] args){
        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                Singleton singleton=Singleton.getInstance();
                System.out.println(singleton.getThread().getName());
            }).start();
        }
    }
}