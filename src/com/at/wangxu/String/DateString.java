package com.at.wangxu.String;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateString {

    public static void main(String[] args) throws Exception{
        String dateStr = "2019-08-22-16.30.32.342933";

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH.mm.ss.SSSSSS");

        Date date = dateFormat.parse(dateStr);

        System.out.println(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSz;").format(date));
    }
}
