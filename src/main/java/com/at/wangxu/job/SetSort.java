package com.at.wangxu.job;

import java.util.*;

public class SetSort {
    public static void main(String[] args){
        List list=new ArrayList();
        HashMap map=new HashMap();
        map.put("1",null);
        map.put("2",null);
        map.put("3",null);
        map.put("1",null);
        list.addAll(map.keySet());
        System.out.println(list.toString());
    }
}
