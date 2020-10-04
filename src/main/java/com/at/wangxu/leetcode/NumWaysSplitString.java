package com.at.wangxu.leetcode;

/**
 * 1573. Number of Ways to Split a String
 * <p>
 * Given a binary string s (a string consisting only of '0's and '1's), we can split s into 3 non-empty strings s1, s2, s3 (s1+ s2+ s3 = s).
 * <p>
 * Return the number of ways s can be split such that the number of characters '1' is the same in s1, s2, and s3.
 * <p>
 * Since the answer may be too large, return it modulo 10^9 + 7.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "10101"
 * Output: 4
 * Explanation: There are four ways to split s in 3 parts where each part contain the same number of letters '1'.
 * "1|010|1"
 * "1|01|01"
 * "10|10|1"
 * "10|1|01"
 * Example 2:
 * <p>
 * Input: s = "1001"
 * Output: 0
 * Example 3:
 * <p>
 * Input: s = "0000"
 * Output: 3
 * Explanation: There are three ways to split s in 3 parts.
 * "0|0|00"
 * "0|00|0"
 * "00|0|0"
 * Example 4:
 * <p>
 * Input: s = "100100010100110"
 * Output: 12
 * <p>
 * <p>
 * Constraints:
 * <p>
 * s[i] == '0' or s[i] == '1'
 * 3 <= s.length <= 10^5
 */
public class NumWaysSplitString {

    public int numWays(String s) {
//        return bruteForce(s);

        //字符串s中含有1的个数
        int count = 0;
        int preSum = 0;
        //preSum 为n的对象有多少个
        long[] arr = new long[s.length() + 1];
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            preSum += aChar - '0';
            arr[preSum] += 1;
            if (aChar == '1')
                count++;
        }
        //如果s中1的个数不能被3整除，说明s无法分割出三部分，使得三个字符串1的个数相同
        if (count % 3 != 0)
            return 0;

        //每一段所包含1的个数
        int perCount = count / 3;

        if (perCount == 0) {
            long size = s.length() - 1;
            //C size 2
            return (int) ((size * (size - 1) / 2) % (Math.pow(10, 9) + 7));
        }

        int tempCount = 0;
        long countA = 1;
        for (int i = 0; i < s.length(); i++) {
            if (tempCount == perCount) {
                if (s.charAt(i) == '0') {
                    countA++;
                    continue;
                } else break;
            }
            if (s.charAt(i) == '1')
                tempCount++;
        }

        tempCount = 0;
        long countB = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (tempCount == perCount) {
                if (s.charAt(i) == '0') {
                    countB++;
                    continue;
                } else break;
            }
            if (s.charAt(i) == '1')
                tempCount++;
        }
//        long l = countA * countB;
        long l = arr[perCount] * arr[2 * perCount];
        return (int) ((l) % (Math.pow(10, 9) + 7));
    }


    public int bruteForce(String s) {
        long ways = 0;
        int length = s.length();
        for (int i = 0; i < length - 2; i++) {
            for (int j = i + 1; j < length - 1; j++) {
                if (judge(s.substring(0, i + 1), s.substring(i + 1, j + 1), s.substring(j + 1))) {
                    ways++;
                }
            }
        }
        return (int) (ways % (Math.pow(10, 9) + 7));
    }

    /**
     * 判断三个字符串的1个数是否相等
     *
     * @param substring  substring
     * @param substring1 substring1
     * @param substring2 substring2
     */
    private boolean judge(String substring, String substring1, String substring2) {
        int count = 0;
        for (int i = 0; i < substring.length(); i++) {
            if (substring.charAt(i) == '1')
                count++;
        }
        int count1 = 0;
        for (int i = 0; i < substring1.length(); i++) {
            if (substring1.charAt(i) == '1')
                count1++;
        }

        if (count != count1)
            return false;

        for (int i = 0; i < substring2.length(); i++) {
            if (substring2.charAt(i) == '1')
                count1--;
        }

        return count1 == 0;
    }


    public static void main(String[] args) {
        NumWaysSplitString splitString = new NumWaysSplitString();
        System.out.println(splitString.numWays("111"));
        System.out.println(splitString.numWays("10101"));
        System.out.println(splitString.numWays("1001"));
        System.out.println(splitString.numWays("0000"));
        System.out.println(splitString.numWays("100100010100110"));
        System.out.println(splitString.numWays("000000000100000100000100001000000000000100100000010000000000000000000000000001000000000000000000000010010000000000100000000000000000000000000100010000000000000000000000011000000000000010000010100001000000000000101000010000000000110000000000000000000000000010100000000000100000000000100000000001000100000000000001100000000000000000000000000000001000010000000001010000001000000000000000000000000000000000000000100000001000000010000000000010000100000000000000000100000000100100000000000000100000011"));
        System.out.println(splitString.numWays("00000000"));
    }
}
