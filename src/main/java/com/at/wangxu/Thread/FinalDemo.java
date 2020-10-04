package com.at.wangxu.Thread;

public class FinalDemo {
    private int a;
    private final int b;
    private static FinalDemo finalDemo;

    public FinalDemo() {
        a = 1;
        b = 2;
    }
    private static void writer(){
        finalDemo=new FinalDemo();
    }
    private static void reader(){
        FinalDemo demo=finalDemo;
        int a=demo.a;
        int b=demo.b;
    }
}
