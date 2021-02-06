package com.at.wangxu.competition;

public class MaximumBinaryString {

    /**
     * 00 -> 10
     * 10 -> 01
     * @param binary src binary string
     * @return maximum
     */
    public String maximumBinaryString(String binary) {
//        binary.toCharArray().for
        return "";
    }

    public static void main(String[] args) {
        String src = "000110";
        while (src.contains("00")) {
            src = src.replace("00", "10");
        }
        System.out.println(src);
    }
}
