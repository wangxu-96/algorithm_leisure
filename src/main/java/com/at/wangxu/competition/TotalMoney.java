package com.at.wangxu.competition;

public class TotalMoney {
    public int totalMoney(int n) {
        int res = 0;
        int start = 0;
        int first = 1;
        while (n > 0) {
            for (int i = 0; i < 7 && n >0; i++) {
                if (i == 0) {
                    first = ++ start;
                    res += first;
                }else {
                    res += first + i;
                }
                 n --;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TotalMoney money = new TotalMoney();
        System.out.println(money.totalMoney(10));
    }
}
