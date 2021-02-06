package com.at.wangxu.leetcode;

import java.util.*;

/**
 * 399. 除法求值
 */
public class CalcEquation {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        return new double[]{};
    }

    public static void main(String[] args) {
        CalcEquation equation = new CalcEquation();
        List<List<String>> equations = new LinkedList<>();
        List<String> stringList = new LinkedList<>();
        stringList.add("a");
        stringList.add("b");
        equations.add(stringList);

        stringList = new LinkedList<>();
        stringList.add("b");
        stringList.add("c");
        equations.add(stringList);

        List<List<String>> queries = new LinkedList<>();

        stringList = new LinkedList<>();
        stringList.add("a");
        stringList.add("c");
        queries.add(stringList);

        Arrays.stream(equation.calcEquation(equations, new double[]{2.0, 3.0}, queries)).forEach(System.out::println);
    }
}
