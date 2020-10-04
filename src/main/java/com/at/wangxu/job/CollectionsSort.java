package com.at.wangxu.job;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionsSort {
    public static void main(String[] args){
        List strList=new ArrayList<>();
        strList.add("22345");
        strList.add("123456");
        Collections.sort(strList, new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((String)o1).compareTo((String) o2);
            }
        });
        for (int i=0;i<strList.size();i++){
            System.out.println(strList.get(i));
        }
    }
}
