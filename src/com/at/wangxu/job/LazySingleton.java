package com.at.wangxu.job;

public class LazySingleton {
    public static volatile LazySingleton lazySingleton;

    private LazySingleton() {
    }
    public static LazySingleton getInstance(){
        if (lazySingleton==null)
            synchronized (LazySingleton.class){
            if (lazySingleton==null)
                lazySingleton=new LazySingleton();
            }
        return lazySingleton;
    }
    public static void main(String[] args){
        LazySingleton.getInstance();
    }
}
