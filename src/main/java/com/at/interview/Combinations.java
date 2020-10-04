package com.at.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  从List中选取n个元素的所有组合
 */
public class Combinations {


    private void combinations(List<Integer> selected, List<Integer> data, int n) {
        if (n == 0) {
            for (Integer integer : selected) {
                System.out.print(integer);
                System.out.print(" ");
            }
            System.out.println();
            return;
        }
        if (data.isEmpty()) {
            return;
        }

        selected.add(data.get(0));
        combinations(selected, data.subList(1, data.size()), n - 1);

        selected.remove(selected.size() - 1);
        combinations(selected, data.subList(1, data.size()), n);


    }


    public static void main(String[] args) {
        Combinations combinations = new Combinations();
        combinations.combinations(new ArrayList<>(),Arrays.asList(1,2,3,4),2);

    }
}
