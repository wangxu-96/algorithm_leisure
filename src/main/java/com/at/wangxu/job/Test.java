package com.at.wangxu.job;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5));
            for (int j = 0; j < list.size(); j++) {
                if ( list.get(j) > 3) {
                    list.remove(j);
                    j --;
                }
            }
        list.forEach(System.out::println);
    }
}
