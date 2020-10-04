package com.at.leetcode;

/**
 * Leetcode 6 ZigZag Conversion
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 */
public class ZigZagConversion {

    public String convert(String s,int numRows){
        if(s == null || s.length()==0 || numRows <=0)
            return "";
        if(numRows == 1)
            return s;
        StringBuilder res = new StringBuilder();
        int size = 2*numRows-2;
        for(int i=0;i<numRows;i++) {
            for(int j=i;j<s.length();j+=size) {
                res.append(s.charAt(j));
                if(i!=0 && i!=numRows-1 && (j-i)+(size-i)<s.length())
                    res.append(s.charAt((j-i)+(size-i)));
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        ZigZagConversion bean = new ZigZagConversion();
        System.out.println(bean.convert("PAYPALISHIRING",3));
    }
}
