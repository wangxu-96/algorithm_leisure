package com.at.wangxu.job;

import java.io.UnsupportedEncodingException;

public class CrcTest {
    private static String[] charsetArr = {"UTF-8","GB18030","GB2312","GBK","Windows-1252","ISO8859-1"};

    public static void testAllCharset(String text) throws UnsupportedEncodingException {
        if (text == null || text.length() == 0) {
            System.out.println("文本不能为空");
            return;
        }

        System.out.println("假设当前编码       假设原始编码          编码后的内容");
        printSeparator();

        for (String curCharset : charsetArr) {
            byte[] btArr = text.getBytes(curCharset);
            for (String originCharset : charsetArr) {
                if (originCharset.equals(curCharset)) {
                    continue;
                }
                String encodeText = new String(btArr,originCharset);
                printTable(curCharset, originCharset, encodeText);
            }
            printSeparator();
        }
    }

    private static void printSeparator() {
        System.out.println("--------------------------------------------------------");
    }

    private static void printTable(String curCharset, String originCharset, String encodeText) {
        System.out.print(curCharset);
        for (int i = 0; i < 15 - curCharset.length(); i++) {
            System.out.print(" ");
        }
        System.out.print("|   " + originCharset);
        for (int i = 0; i < 16 - originCharset.length(); i++) {
            System.out.print(" ");
        }
        System.out.println("|     " + encodeText);
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        //测试乱码
        testAllCharset("〱㐲");
        testAllCharset("〱〰ㄱ〱〱ㄱ〱〱〱ㄱ〰〱〱ㄱ〰〱〰ㄱㄱㄱㄱ0〰ㄱ");
    }
}
