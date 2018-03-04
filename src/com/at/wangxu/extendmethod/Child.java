package com.at.wangxu.extendmethod;

import com.at.wangxu.extendmethod.Father;

public class Child extends Father {
    public Child() {

        step=10;
        _fldlong=0L;
        _fldvoid=step+1;
    }


    private int step;
    private int _fldvoid;
    private long _fldlong;
    public void setStep(int i) {
        step = i;
        _fldvoid=step+1;

    }

    public void doTest(){

        System.out.println("child doTest 方法"+"-----step:"+step+"----_fldlong:"+_fldvoid+"-----_fldvoid:"+_fldlong);
    }

}
