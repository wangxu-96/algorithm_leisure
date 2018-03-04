package com.at.wangxu.Blog;

import java.util.ArrayList;
import java.util.List;

public class Transfer {
    public static void main(String[] args){
        List<String> list=new ArrayList<>();
        List list1=list;
        list1.add("2");
        System.out.println(list.toString());
        String s="1";
        s=s+2;
        System.out.println(s);
    }
}
