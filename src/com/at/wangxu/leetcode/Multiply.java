package com.at.wangxu.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 43. 字符串相乘
 * <p>
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * <p>
 * 示例 1:
 * <p>
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 * <p>
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 说明：
 * <p>
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 */
public class Multiply {

    /**
     * 像排竖式那样相乘，维持好进位
     *
     * @param num1 num1
     * @param num2 num2
     * @return num1*num2
     */
    public String multiply(String num1, String num2) {

        if (num1.equals("0") || num2.equals("0"))
            return "0";
        int i = num1.length();
        int j = num2.length();
        List<String> list = new ArrayList<>();
        int maxLength = 0;


        for (int k = j - 1; k >= 0; k--) {
            int curry = 0;
            StringBuilder partialSum = new StringBuilder();
            for (int l = i - 1; l >= 0; l--) {
                int i1 = Integer.parseInt(String.valueOf(num1.charAt(l)));
                int i2 = Integer.parseInt(String.valueOf(num2.charAt(k)));
                partialSum.append((i1 * i2 + curry) % 10);
                curry = (i1 * i2 + curry) / 10;
            }
            if (curry > 0)
                partialSum.append(curry);
            StringBuilder reverse = partialSum.reverse();
            int abs = Math.abs(k - (j - 1));
            while (abs > 0) {
                reverse.append("0");
                abs--;
            }
            maxLength = Math.max(maxLength, reverse.length());
            list.add(reverse.toString());
        }

        //iterator list add all sum;
        int index = 0;
        StringBuilder result = new StringBuilder();
        int c = 0;
        while (index < maxLength) {
            int partialSum = 0;
            for (String s : list) {
                if (s.length() - 1 - index >= 0) {
                    partialSum += Integer.parseInt(String.valueOf(s.charAt(s.length() - 1 - index)));
                }
            }
            result.append((partialSum + c) % 10);
            c = (partialSum + c) / 10;
            index++;
        }
        if (c > 0)
            result.append(c);

        return result.reverse().toString();
    }


    /**
     * 递归的求num1*num2 最后将其转换成四位数的乘法(因为9999*9999不会超过Integer.MAX_VALUE)，
     *
     * @param num1 num1
     * @param num2 num2
     * @return num1*num2
     */
    public String mul(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0"))
            return "0";
        if (num1.length() > 4) {
            int mid = num1.length() / 2;
            return add(mul(num1.substring(0, mid), num2), mul(num1.substring(mid), num2), (num1.length() - mid));
        }
        if (num2.length() > 4) {
            int mid = num2.length() / 2;
            return add(mul(num1, num2.substring(0, mid)), mul(num1, num2.substring(mid)), (num2.length() - mid));
        }
        return String.valueOf(Integer.parseInt(num1) * Integer.parseInt(num2));
    }

    /**
     * 两个大数相加
     *
     * @param num1 num1
     * @param num2 num2
     * @param zero zero nums1 后面应该加的0的个数
     * @return num1*math.pow(10,zero)+nums2
     */
    public String add(String num1, String num2, int zero) {
        StringBuilder num1Builder = new StringBuilder(num1);
        while (zero > 0) {
            num1Builder.append("0");
            zero--;
        }
        num1 = num1Builder.toString();
        int maxLength = Math.max(num1.length(), num2.length());
        int index = 0;
        StringBuilder stringBuilder = new StringBuilder();
        int curry = 0;
        while (index < maxLength) {
            int partialSum = 0;

            if (num1.length() - 1 - index >= 0) {
                partialSum += Integer.parseInt(String.valueOf(num1.charAt(num1.length() - 1 - index)));
            }
            if (num2.length() - 1 - index >= 0) {
                partialSum += Integer.parseInt(String.valueOf(num2.charAt(num2.length() - 1 - index)));
            }

            stringBuilder.append((partialSum + curry) % 10);
            curry = (partialSum + curry) / 10;
            index++;
        }
        if (curry > 0)
            stringBuilder.append(curry);
        return stringBuilder.reverse().toString();
    }


    /**
     * 先把每一位的值算出来放入数组中，最后统一进位
     * @param num1 num1
     * @param num2 num2
     * @return num1*num2
     */
    public String multiplyOfficial(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0"))
            return "0";
        int i = num1.length();
        int j = num2.length();

        int[] arr = new int[i + j];
        for (int k = j - 1; k >= 0; k--) {
            for (int l = i - 1; l >= 0; l--) {
                int x = num2.charAt(k) - '0';
                int y = num1.charAt(l) - '0';

                arr[j - 1 - k + i - 1 - l] += x * y;
            }
        }

        int curry = 0;
        for (int i1 = 0; i1 < arr.length; i1++) {
            int temp = (arr[i1] + curry) % 10;
            curry = (arr[i1] + curry) / 10;
            arr[i1] = temp;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i1 : arr) {
            stringBuilder.append(i1);
        }
        String result = stringBuilder.reverse().toString();
        while (result.startsWith("0")) {
            result = result.substring(1);
        }
        return result;
    }

    public static void main(String[] args) {
//        System.out.println(new Multiply().multiply("123", "456"));
//        System.out.println(new Multiply().mul("123", "456"));
//        System.out.println(new Multiply().multiply("2", "3"));
//        System.out.println(new Multiply().mul("2", "3"));
//        System.out.println(new Multiply().multiply("1234", "1234"));
//        System.out.println(new Multiply().mul("1234", "1234"));
        System.out.println(new Multiply().multiply("9999", "9999"));
        System.out.println(new Multiply().mul("9999", "9999"));
        System.out.println(new Multiply().multiplyOfficial("9999", "9999"));
    }
}
