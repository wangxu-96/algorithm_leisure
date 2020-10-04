package com.at.wangxu.Thread;

public class EspaceAnalysis {
    private Thread t;
    public EspaceAnalysis() {
        System.out.println(EspaceAnalysis.this);
        System.out.println(Thread.currentThread());
        this.t=new Thread(InnerClass::new);
    }
    class InnerClass{
        public InnerClass() {
            System.out.println(EspaceAnalysis.this);
            System.out.println(Thread.currentThread());
        }
    }
    public static void main(String[] args){
        getMainInstance();
    }

    public static EspaceAnalysis getMainInstance(){
        EspaceAnalysis espaceAnalysis=new EspaceAnalysis();
        espaceAnalysis.t.start();
        return espaceAnalysis;
    }
}
