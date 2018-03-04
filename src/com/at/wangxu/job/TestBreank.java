package com.at.wangxu.job;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TestBreank {



    public static void main(String[] args){
        List<String> reProList=new ArrayList<>();
        reProList.add("1");
        reProList.add("1");
        reProList.add("1");
        reProList.add("2");
        reProList.add("3");
        reProList.add("1");
        System.out.println(reProList.toString());
        reProList=reProList.subList(6,reProList.size());
        System.out.println(reProList.toString());

    }
}
