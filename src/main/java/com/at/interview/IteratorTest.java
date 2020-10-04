package com.at.interview;

import java.util.*;

public class IteratorTest {

    public static void main(String[] args) {
        String[] a = new String[]{"2","3","4"};
        Iterator<String> iterator = new ArrayList<>(Arrays.asList(a)).iterator();

        while (iterator.hasNext()){
            String next = iterator.next();
            if (next.equalsIgnoreCase("2")){
                iterator.remove();
            }
        }

        Arrays.stream(a).forEach(System.out::println);


        String[] arr = new String[]{"1","2","3"};
        List<String> list = new ArrayList<>(Arrays.asList(arr));
        Iterator<String> iterator1 = list.iterator();
        while (iterator1.hasNext()){
            String next = iterator1.next();
            if (next.equalsIgnoreCase("1")){
                iterator1.remove();
            }
        }
        list.stream().forEach(System.out::println);
        Arrays.stream(arr).forEach(System.out::println);

    }
}
