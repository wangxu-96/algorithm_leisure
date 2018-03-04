package com.at.wangxu.job;

import java.util.ArrayList;
import java.util.List;

public class SubList {
    public static void main(String[] args){
        List<String> strList=new ArrayList<String>();
        strList.add("1");
        strList.add("2");
        strList.add("3");
        strList.add("4");
        strList.add("5");
        strList.add("6");
        System.out.println(strList.subList(0,5).toString());
    }
}
