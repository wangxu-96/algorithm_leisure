package com.at.wangxu.leetcode;

/**
 * 5789. 你完成的完整对局数 HH:00、HH:15、HH:30 和 HH:45
 * 
 * https://leetcode-cn.com/problems/the-number-of-full-rounds-you-have-played/solution/ni-wan-cheng-de-wan-zheng-dui-ju-shu-by-df44r/
 */
public class NumberOfRounds {

    static String split = ":";

    public int numberOfRounds(String startTime, String finishTime) {
        String start_hour = startTime.split(split)[0];
        int start_hour_int = Integer.parseInt(start_hour);
        String start_min = startTime.split(split)[1];
        int start_min_int = Integer.parseInt(start_min);
        String finish_hour = finishTime.split(split)[0];
        int finish_hour_int = Integer.parseInt(finish_hour);
        String finish_min = finishTime.split(split)[1];
        int finish_min_int = Integer.parseInt(finish_min);
        if (start_hour_int == finish_hour_int) {
            if (start_min_int > finish_min_int) {
                int count = 23 * 4;
                // [00,15] [16,30] [31,45] [46,59]
                if (start_min_int == 0)
                    count += 4;
                else if (start_min_int > 0 && start_min_int <= 15)
                    count += 3;
                else if (start_min_int > 15 && start_min_int <= 30)
                    count += 2;
                else if (start_min_int > 30 && start_min_int <= 45)
                    count += 1;

                if (finish_min_int >= 15 && finish_min_int < 30)
                    count += 1;
                else if (finish_min_int >= 30 && finish_min_int < 45)
                    count += 2;
                else if (finish_min_int >= 45)
                    count += 3;
                return count;
            } else {
                // [00,15] [16,30] [31,45] [46,59]
                if (start_min_int == 0)
                    if (finish_min_int >= 45)
                        return 3;
                    else if (finish_min_int >= 30)
                        return 2;
                    else if (finish_min_int >= 15)
                        return 1;
                    else
                        return 0;
                else if (start_min_int > 0 && start_min_int <= 15)
                    if (finish_min_int >= 45)
                        return 2;
                    else if (finish_min_int >= 30)
                        return 1;
                    else
                        return 0;
                else if (start_min_int > 15 && start_min_int <= 30)
                    if (finish_min_int >= 45)
                        return 1;
                    else
                        return 0;
                else if (start_min_int > 30 && start_min_int <= 45)
                    return 0;
            }

            return 0;
        } else if (start_hour_int > finish_hour_int) {
            // cross day
            int sub = finish_hour_int + 24 - start_hour_int - 1;
            int count = 0;
            // [00,15] [16,30] [31,45] [46,59]
            if (start_min_int == 0)
                count += 4;
            else if (start_min_int > 0 && start_min_int <= 15)
                count += 3;
            else if (start_min_int > 15 && start_min_int <= 30)
                count += 2;
            else if (start_min_int > 30 && start_min_int <= 45)
                count += 1;

            if (finish_min_int >= 15 && finish_min_int < 30)
                count += 1;
            else if (finish_min_int >= 30 && finish_min_int < 45)
                count += 2;
            else if (finish_min_int >= 45)
                count += 3;
            return sub * 4 + count;
        } else {
            int sub = Integer.parseInt(finish_hour) - Integer.parseInt(start_hour) - 1;
            int count = 0;
            // [00,15] [16,30] [31,45] [46,59]
            if (start_min_int == 0)
                count += 4;
            else if (start_min_int > 0 && start_min_int <= 15)
                count += 3;
            else if (start_min_int > 15 && start_min_int <= 30)
                count += 2;
            else if (start_min_int > 30 && start_min_int <= 45)
                count += 1;

            if (finish_min_int >= 15 && finish_min_int < 30)
                count += 1;
            else if (finish_min_int >= 30 && finish_min_int < 45)
                count += 2;
            else if (finish_min_int >= 45)
                count += 3;
            return sub * 4 + count;
        }
    }

    public static void main(String[] args) {
        NumberOfRounds rounds = new NumberOfRounds();
        System.out.println(rounds.numberOfRounds("12:01", "12:44"));
        System.out.println(rounds.numberOfRounds("20:00", "06:00"));
        System.out.println(rounds.numberOfRounds("00:00", "23:59"));
        System.out.println(rounds.numberOfRounds("00:01", "00:00"));
    }

}