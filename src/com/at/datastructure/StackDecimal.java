package com.at.datastructure;

import java.util.Scanner;
import java.util.Stack;

public class StackDecimal {

    public static void main(String[] args){
        Stack stack=new Stack();
        Scanner scanner=new Scanner(System.in);
        int input=scanner.nextInt();
        while (input!=0){
            stack.push(input%8);
            input/=8;
        }
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
        scanner.close();
    }
}
