package com.at.jvm;

import java.util.ArrayList;
import java.util.List;

public class Loop {

    static final int SIZE = 50*1024*1024;

    public static void main(String[] args){

        List<Object> list = new ArrayList<>();

        while (true){
            Object arr = new int[SIZE];

            list.add(arr);
            System.out.println(list.size());

            if (list.size() == 10)
                list.clear();
        }
    }
}
