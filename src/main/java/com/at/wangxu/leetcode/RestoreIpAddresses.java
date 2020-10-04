package com.at.wangxu.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 93. 复原IP地址
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 * <p>
 * 有效的 IP 地址正好由四个整数（每个整数位于 0 到 255 之间组成），整数之间用 '.' 分隔。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 * <p>
 * 来源：力扣（LeetCode）
 */
public class RestoreIpAddresses {


    static final int SEG_COUNT = 4;
    List<String> ans = new ArrayList<>();
    int[] segments = new int[SEG_COUNT];

    public List<String> restoreIpAddresses1(String s) {
        segments = new int[SEG_COUNT];
        dfs(s, 0, 0);
        return ans;
    }

    public void dfs(String s, int segId, int segStart) {
        // 如果找到了 4 段 IP 地址并且遍历完了字符串，那么就是一种答案
        if (segId == SEG_COUNT) {
            if (segStart == s.length()) {
                StringBuilder ipAddr = new StringBuilder();
                for (int i = 0; i < SEG_COUNT; ++i) {
                    ipAddr.append(segments[i]);
                    if (i != SEG_COUNT - 1) {
                        ipAddr.append('.');
                    }
                }
                ans.add(ipAddr.toString());
            }
            return;
        }

        // 如果还没有找到 4 段 IP 地址就已经遍历完了字符串，那么提前回溯
        if (segStart == s.length()) {
            return;
        }

        // 由于不能有前导零，如果当前数字为 0，那么这一段 IP 地址只能为 0
        if (s.charAt(segStart) == '0') {
            segments[segId] = 0;
            dfs(s, segId + 1, segStart + 1);
        }

        // 一般情况，枚举每一种可能性并递归
        int addr = 0;
        for (int segEnd = segStart; segEnd < s.length(); ++segEnd) {
            addr = addr * 10 + (s.charAt(segEnd) - '0');
            if (addr > 0 && addr <= 0xFF) {
                segments[segId] = addr;
                dfs(s, segId + 1, segEnd + 1);
            } else {
                break;
            }
        }
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> strings = new ArrayList<>();
        char[] chars = s.toCharArray();
        //把一个字符串用三个.分隔，求出满足条件的三个.放置的位置
        for (int i = 0; i <= chars.length - 4; i++) {
            //长度大于3或者值大于255就不用循环了
            if (i > 3 || judge(s.substring(0, i + 1)))
                break;
            for (int i1 = i + 1; i1 <= chars.length - 3; i1++) {
                if (i1 - i > 3 || judge(s.substring(i + 1, i1 + 1)))
                    break;
                for (int i2 = i1 + 1; i2 <= chars.length - 2; i2++) {
                    if (i2 - i1 > 3 || judge(s.substring(i1 + 1, i2 + 1)))
                        break;
                    if (chars.length - 1 - i2 > 3 || judge(s.substring(i2 + 1)))
                        continue;
                    StringBuilder stringBuilder = new StringBuilder();
                    for (int i3 = 0; i3 < chars.length; i3++) {
                        stringBuilder.append(chars[i3]);
                        if (i3 == i || i3 == i1 || i3 == i2) {
                            stringBuilder.append(".");
                        }
                    }
                    String s1 = stringBuilder.toString();
                    strings.add(s1);
                }
            }
        }
        return strings;
    }

    private boolean judge(String s) {
        return Integer.parseInt(s) > 255
                || s.equals("00") || s.equals("000")
                || (s.startsWith("0") && Integer.parseInt(s) > 0);
    }

    public static void main(String[] args) {
        System.out.println("25525511135".substring(0, 4));
        RestoreIpAddresses ipAddresses = new RestoreIpAddresses();
        List<String> strings = ipAddresses.restoreIpAddresses("2736786374048");
        List<String> strings1 = ipAddresses.restoreIpAddresses1("010010");
        strings.forEach(System.out::println);
        strings1.forEach(System.out::println);
    }
}
