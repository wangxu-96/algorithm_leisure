package com.at.wangxu.leetcode;

public class CanCompleteCircuit {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas.length != cost.length)
            return -1;
        if (gas.length == 1)
            return 0;
        int[] sub = new int[gas.length];
        for (int i = 0; i < cost.length; i++) {
            sub[i] = gas[i] - cost[i - 1 == -1 ? cost.length - 1 : i - 1];
        }

        for (int i = 0; i < sub.length; i++) {
            
        }
        return -1;
    }

    public static void main(String[] args) {
        CanCompleteCircuit canCompleteCircuit = new CanCompleteCircuit();
        //System.out.println(
                //canCompleteCircuit.canCompleteCircuit(new int[] { 1, 2, 3, 4, 5 }, new int[] { 3, 4, 5, 1, 2 }));
        //System.out.println(canCompleteCircuit.canCompleteCircuit(new int[] { 2, 3, 4 }, new int[] { 3, 4, 3 }));
        System.out.println(canCompleteCircuit.canCompleteCircuit(new int[] { 5,1,2, 3, 4 }, new int[] { 4,4,1,5,1}));
    }
}
