package com.at.wangxu.codeforces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AFloorNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        List<List<Integer>> lists = new ArrayList<>();
        while (size -- > 0){
            int n = scanner.nextInt();
            int x = scanner.nextInt();
            lists.add(Arrays.asList(n,x));
        }
        for (List<Integer> list : lists) {
            System.out.println(calc(list.get(0),list.get(1)));
        }
//        System.out.println(calc(7,3));
//        System.out.println(calc(1,5));
//        System.out.println(calc(22,5));
//        System.out.println(calc(987,13));
    }

    public static int calc(int n,int x) {
        if (n <= 2)
            return 1;
        n -= 2;
        return 1 + n/x + (n % x == 0 ? 0 : 1);
    }
}
