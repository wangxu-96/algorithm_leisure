package com.at.wangxu.job;

import com.at.interview.common.Node;

import java.util.HashMap;
import java.util.Map;

public class BigFile {
    public static void main(String[] args){
        Node o = new Node(2);
        Node temp = o;
        o.setNext(new Node(3));
        System.out.println(temp.getNext().getValue());
    }
}
