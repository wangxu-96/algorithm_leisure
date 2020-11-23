package com.at.wangxu.competition;

/**
 * 5606. 具有给定数值的最小字符串
 */
public class GetSmallestString {
    
    public String getSmallestString(int n, int k) {
        StringBuilder stringBuilder = new StringBuilder();
        while (n  > 0) {
            int index = k - (n - 1);
            if (index > 26) {
                index = 26;
            }
            stringBuilder.append((char)('a' + (index -1))) ;
            n --;
            k -= index;
        }
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        GetSmallestString smallestString = new GetSmallestString();
        System.out.println(smallestString.getSmallestString(3, 27));
        System.out.println(smallestString.getSmallestString(5, 73));
    }

}
