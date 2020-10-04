package com.at.wangxu.job;

import java.util.*;

public class SetSequence {
    static class OOMObject{

    }
    public static void main(String[] args){
        Set<String> set=new LinkedHashSet<>();
        set.add("2");
        set.add("2");
        set.add("3");
        set.add("1");
        set.add("3");
        List list=new ArrayList(set);
        for (int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
        List<OOMObject> list1=new ArrayList<>();
        while (true){
            list1.add(new OOMObject());
        }
    }
}
