package com.at.wangxu.Util;

import java.util.Random;

public class CreateArray {

    /**
     * 根据长度创建数组
     * @param length
     * @return
     */
    public static int[] create(int length){
        int[] arr=new int[length];
        Random random=new Random();
        for (int i=0;i<length;i++){
            arr[i]=random.nextInt(length);
        }
        return arr;
    }
    /**
     * 打印数组的值
     */
    public static void printArray(int[] arr){
        for (int i = 0; i <arr.length ; i++) {
            System.out.print(arr[i]+"\t");
        }
    }
}
