package com.at.wangxu.job;

public class Multi {

    public static void main(String[] args) {
        int coreSize = Runtime.getRuntime().availableProcessors();
        for (int i = 0; i < coreSize; i++) {
            new Thread(()->{
                int j = 0;
                while (j < Integer.MAX_VALUE){
                    j ++;
                }
            }).start();
        }
    }
}
