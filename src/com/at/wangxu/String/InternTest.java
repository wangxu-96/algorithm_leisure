package com.at.wangxu.String;

public class InternTest {

    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = new String("abc");
        String s3 = new String("abc");
        String s4 = "ab" + "c";
        String s5 = "ab";
        String s6 = "c";
        String s7 = s5 + s6;
        System.out.println(s1 == s4);
    }
}
