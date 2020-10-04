package com.at.wangxu.newcoder;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 *
 * 保证base和exponent不同时为0
 */
public class Power {

    public double Power(double base, int exponent) {
        if (exponent < 0) {
            base = 1 / base;
            exponent = -exponent;
        }
        return q_power(base, exponent);

    }
    public double q_power(double base,int exponent){
        if (exponent == 0)
            return 1.0;
        double power = Power(base, exponent / 2);
        if (exponent % 2 == 1)
            return power * power * base;
        else
            return power * power;
    }

    public static void main(String[] args) {
        System.out.println(new Power().Power(0.1, 3));
    }
}
