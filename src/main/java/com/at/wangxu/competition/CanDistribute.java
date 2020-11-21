package com.at.wangxu.competition;

import java.util.Map;

public class CanDistribute {
    
    public boolean canDistribute(int[] nums, int[] quantity) {
        int[] buket  = new int[1000 + 1];
        for (int i = 0; i < nums.length; i++) {
            buket[nums[i]] ++;
        }
        
        for (int i = 0; i < buket.length; i++) {
            
        }
        return false;
    }

    public static void main(String[] args) {
        CanDistribute canDistribute = new CanDistribute();
        System.out.println(canDistribute.canDistribute(new int[]{1,2,3,4}, new int[]{2}));
        System.out.println(canDistribute.canDistribute(new int[]{1,2,3,3}, new int[]{2}));
        System.out.println(canDistribute.canDistribute(new int[]{1,1,2,2}, new int[]{2,2}));
        System.out.println(canDistribute.canDistribute(new int[]{1,1,2,3}, new int[]{2,2}));
        System.out.println(canDistribute.canDistribute(new int[]{1,1,1,1,1}, new int[]{2,3}));
    }
}
