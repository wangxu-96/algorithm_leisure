package com.at.wangxu.spider;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class SpiderDemo {
    public static void main(String[] args) throws Exception {
        URLConnection urlConnection=new URL("http://odds.500.com/").openConnection();
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(urlConnection.getInputStream(),"gb2312"));
        String line;
        StringBuilder sb=new StringBuilder();
        while ((line=bufferedReader.readLine())!=null){
            sb.append(line+"\n");
        }
        System.out.println(sb.toString());
    }


}
