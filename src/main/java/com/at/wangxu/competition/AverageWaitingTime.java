package com.at.wangxu.competition;

public class AverageWaitingTime {

    public double averageWaitingTime(int[][] customers) {
        int preTime = -1;
        double all = 0;
        for (int[] customer : customers) {
            int arriveTime = customer[0];
            int costTime = customer[1];

            if (preTime <= arriveTime) {
                all += costTime;
                preTime = arriveTime + costTime;
            } else {
                all += preTime - arriveTime + costTime;
                preTime += costTime;
            }
        }
        return all / customers.length;
    }

    public static void main(String[] args) {
        AverageWaitingTime bean = new AverageWaitingTime();
        System.out.println(bean.averageWaitingTime(new int[][]{{1, 2}, {2, 5}, {4, 3}}));
    }

}
