package com.at.wangxu.Thread;

public class JoinDemo {
    public static void main(String[] args){
        Thread previousThread=Thread.currentThread();
        for (int i = 0; i < 10; i++) {
            Thread curThread=new JoinThread(previousThread);
            curThread.start();
            previousThread=curThread;
        }
    }
    static class JoinThread extends Thread{
        private Thread thread;

        public JoinThread(Thread thread) {
            this.thread = thread;
        }

        @Override
        public void run() {
            try {
                thread.join();
                System.out.println(thread.getName()+" terminated");
            }catch (InterruptedException e){

            }
        }
    }
}
