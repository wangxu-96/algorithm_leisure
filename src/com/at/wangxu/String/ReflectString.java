package com.at.wangxu.String;

import java.lang.reflect.Field;

public class ReflectString {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        String a = "abc";
        Field field = String.class.getDeclaredField("value");
        field.setAccessible(true);
        char[] o = (char[]) field.get(a);
        o[0] = 'd';
        o[1] = 'e';
        o[2] = 'f';
        System.out.println(a);
    }
}
