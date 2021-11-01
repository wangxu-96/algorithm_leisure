package com.at.wangxu.leetcode;

/**
 * 482. 密钥格式化
 */
public class LicenseKeyFormatting {

    public static String licenseKeyFormatting(String s, int k) {
        StringBuilder stringBuilder = new StringBuilder();
        int index = k;
        char[] chars = s.toCharArray();
        for (int i = chars.length - 1; i >= 0 ;--i) {
            char c = chars[i];
            if (c == '-') continue;
            stringBuilder.append(Character.toUpperCase(c));
            index--;
            if (index == 0) {
                index = k;
                stringBuilder.append('-');
            }
        }
        String res = stringBuilder.reverse().toString();
        if (res.startsWith("-")) res = res.substring(1);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(licenseKeyFormatting("5F3Z-2e-9-w", 4));
        System.out.println(licenseKeyFormatting("2-5g-3-J", 2));
    }
}
