package com.at.wangxu.job;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class RichCalendar {

    public static void main(String[] args) throws ParseException {
        String str="20180410";
        System.out.println(str.substring(0,6)+"01");

        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
        Date date=sdf.parse(str);
        System.out.println("当前月的第一天:---"+getFirstDay(date));
    }

    /**
     * 当月第一天
     * @return
     */
    private static String getFirstDay(Date date) {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");

        GregorianCalendar gcLast = (GregorianCalendar) Calendar.getInstance();
        gcLast.setTime(date);
        gcLast.set(Calendar.DAY_OF_MONTH, 1);
        String day_first = df.format(gcLast.getTime());
        StringBuffer str = new StringBuffer().append(day_first).append(" 00:00:00");
        return str.toString();

    }

    public static String getLastDayOfMonth(int year,int month)
    {
        Calendar cal = Calendar.getInstance();
        //设置年份
        cal.set(Calendar.YEAR,year);
        //设置月份
        cal.set(Calendar.MONTH, month-1);
        //获取某月最大天数
        int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        //设置日历中月份的最大天数
        cal.set(Calendar.DAY_OF_MONTH, lastDay);
        //格式化日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String lastDayOfMonth = sdf.format(cal.getTime());

        return lastDayOfMonth;
    }
}
