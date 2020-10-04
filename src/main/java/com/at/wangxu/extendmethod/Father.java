package com.at.wangxu.extendmethod;

public class Father {
    public Father() {
    }


    public void doTest(){
        System.out.println("Father doTest 方法");
    }

    public void generator(){
        doTest();
    }
}
