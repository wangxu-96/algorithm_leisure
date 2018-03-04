package com.at.wangxu.job;

import java.util.ArrayList;
import java.util.List;

public class IntegerTest {
    public static void main(String[] args){
        Integer a=new Integer(1);
        Integer b=a;
        dos(b);
        System.out.println(a.intValue());
        System.out.println(a==b);
        List<String> stringList=new ArrayList<>();
        stringList.add("1");
        dos(stringList);
        System.out.println(stringList.toString());
    }
    private static void dos(Integer integer){
        integer=new Integer(2);
    }
    private static void dos(List list){
        list.add("2");
    }
}
