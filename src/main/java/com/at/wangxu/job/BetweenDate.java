package com.at.wangxu.job;


public class BetweenDate {
    public static void main(String[] args){
        String date="15";
        String beginDate="20180725";
        String endDate="20180805";
        System.out.println(isBetween(date,beginDate,endDate));

    }
    private static boolean isBetween(String date,String beginDate,String endDate){
        int dateInt=Integer.parseInt(date.trim());
        int beginDateInt=Integer.parseInt(beginDate.substring(6));
        int endDateInt=Integer.parseInt(endDate.substring(6));

        if (beginDateInt<endDateInt){
            return dateInt >= beginDateInt && dateInt <= endDateInt;
        }else{
            return dateInt >= beginDateInt || dateInt <= endDateInt;
        }
    }
}
