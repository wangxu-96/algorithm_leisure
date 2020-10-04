package com.at.wangxu.newcoder;

public class JumpFloorII {
    public int JumpFloorII(int target) {
        if (target == 1 || target == 2)
            return target;

        int a = 1;
        int b = 2;
        int sum = a + b;
        int c = 0;
        for (int i = 3; i <= target ; i++) {
            c = sum + 1;
            sum +=c;
        }
        return c;
    }

    public static void main(String[] args) {
        System.out.println(new JumpFloorII().JumpFloorII(5));
    }
}
