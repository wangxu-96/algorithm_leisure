package com.at.wangxu.job;

public class CanChangeString {
    public  static void main(String[] args){
        changeStr("1", "2","3");
    }

    public synchronized static String changeStr(String a,String b,String c){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(a);
        stringBuffer.append(b);
        stringBuffer.append(c);
        return stringBuffer.toString();
    }
}
