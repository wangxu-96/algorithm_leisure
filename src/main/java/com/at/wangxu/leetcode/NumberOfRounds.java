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

    static boolean t() {

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // NumberOfRounds rounds = new NumberOfRounds();
        // System.out.println(rounds.numberOfRounds("12:01", "12:44"));
        // System.out.println(rounds.numberOfRounds("20:00", "06:00"));
        // System.out.println(rounds.numberOfRounds("00:00", "23:59"));
        // System.out.println(rounds.numberOfRounds("00:01", "00:00"));

        String release_str = "45642645,45642645,500,500,978703.90001705883,62.5,307316.09364258783,100,1,0,97.099999999999994,25,48.600000000000001,0,0,22,31.050000000000001,0,0,0,0,0,0,5,0.5,0,1.5,0,0,5,25,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,8.5,1,0,0,0,0,98831335.673192933,0,0,0,0,0,0,0,0,0,820,3000,3000,0,0,72502,31000,84764,80512,93468,61616,0,500,500,50000,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,375421.76999999996,595777.79000000004,607814.40000000002,492239,0.5,1,20,0,0,0,0,0,0,0,0,0,0,0,0,0,0,20,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,31.5,15,0,0,0,0,0,0,0,0,0,0,0,10,0,0,180774,12000,30,5,58,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,31.5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,";
        System.out.println("release: " + release_str.split(",")[129]);

        String dev_str = "503928,503928,500,500,53428.99531651898,136.54545454545456,13584.5,100,1,0,0.5,0,1,0,0,3.5,1.5000000000000013,0,0,0,0,0,0,5,0,0,0,0,11,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,8.1999999999999993,1,0,0,0,0,3101096,0,0,0,0,0,0,0,0,0,820,3000,3000,0,0,0,1000,26000,2500,0,0,0,500,13000,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,20,18995,865,15828,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1.5,0,0,0,0,0,0,0,0,0,0,0,0,10,0,0,12000,12000,30,5,58,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1.5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,";
        System.out.println("dev: " + dev_str.split(",")[129]);

        String s = "788613745.99999964,788613746,500,500,49246123.565528125,410065.99959133641,6142424.5149880378,249.42000071525572,0.40093015681674449,149.42000071525575,687.60000047683729,749.42000081062315,219.70000047683715,0,0,639.16000071525571,110,97.380000381469728,60100,63.43,39.500000000000007,35,54.310000000000002,5,15,7.5,0,0,0,0,27584.9453125,0,0,0,0,0,0,0,0,0,0,0,0,51,21,29,36,30,0,0,5.8872999999999998,1,0,0,0,0,3202808034,0,0,0,0,0,0,0,0,0,113351.8955078125,755,3000,0,0,3739683.1206484991,6251644.9555900851,1183645.2842706824,9772670.198321715,9553716.0288181715,1483250.8352753257,130081.57768000002,121714.74995471998,271186.16963824001,342758.01039999997,658826.55911710346,148019.802536,0,0,0,0,0,0,0,0,0,0,0,0,0,0,56,0,73,0,0,0,0,0,0,0,0,1212341.3161898537,2923371.2551984936,13854400.402172897,1452981.7066255978,35.170000000000002,200.13999999999999,498.90000335693367,65.02000000000001,24339.3447265625,0,0,0,0,0,0,0,0,0,226.46000000000001,29,0,30,96.47999999999999,25.729999999999997,77.659999999999997,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,16,0,0,0,0,0,145.30000047683714,113,0,0,0,0,0,0,0,0,0,0,2561.6000366210938,10,18500,11250,6766000.3087541228,6766000.3087541228,32,5,117,4,0,0,0,0,0,0,0,0,0,0,66150,0,0,0,18,0,0,0,0,0,0,0,0,0,0,0,0,0,0,9,12,429794491.57000005,429794491.56999987,0,0,54.500000000000007,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,4.6398199999999994,0,9.1656600000000008,0,0,0,0,0,0,0,0,131.60527999999999,22,161.71884,34,163.19,32,115,0,250,17,235,34,0,0,265.33332000000001,0,263.89999999999998,154,3.3009999523162841,155.30000047683714,0,0,0,3272,0,64.999999664723873,1,1,0,0,25,0,7,0,";
        System.out.println(s.split(",")[129]);

        System.out.println(NumberOfRounds.t());
    }

}