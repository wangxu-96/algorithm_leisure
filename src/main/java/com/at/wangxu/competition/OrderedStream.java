package com.at.wangxu.competition;

import java.util.LinkedList;
import java.util.List;

public class OrderedStream {
    String[] array;
    int ptr;

    public OrderedStream(int n) {
        this.array = new String[n + 1];
        ptr = 1;
    }

    public List<String> insert(int id, String value) {
        array[id] = value;
        List<String> list = new LinkedList<>();
        if (id != ptr)
            return list;
        for (int i = id; i < array.length; i++) {
            if (array[i] == null)
                break;

            ptr = i + 1;
            list.add(array[i]);
        }
        return list;
    }

    public static void main(String[] args) {
        OrderedStream orderedStream = new OrderedStream(5);
        orderedStream.insert(3, "ccccc").stream().forEach(System.out::println);
        orderedStream.insert(1, "aaaaa").stream().forEach(System.out::println);
        orderedStream.insert(2, "bbbbb").stream().forEach(System.out::println);
        orderedStream.insert(5, "eeeee").stream().forEach(System.out::println);
        orderedStream.insert(4, "ddddd").stream().forEach(System.out::println);
    }
}
