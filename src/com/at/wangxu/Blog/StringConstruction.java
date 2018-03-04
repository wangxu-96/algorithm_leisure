package com.at.wangxu.Blog;


import com.sun.deploy.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class StringConstruction {



    public static void main(String[] args){
        String str=new String("hello");
        Map map=new HashMap(16,0.75f);
        StringBuffer stringBuffer=new StringBuffer();
        int a=10;
        a=a>>1;
        System.out.println(a);
    }
}
