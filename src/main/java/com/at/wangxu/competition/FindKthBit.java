package com.at.wangxu.competition;

/**
 * 1545. 找出第 N 个二进制字符串中的第 K 位 显示英文描述
 * 通过的用户数2841
 * 尝试过的用户数3149
 * 用户总通过次数2880
 * 用户总提交次数5459
 * 题目难度Medium
 * 给你两个正整数 n 和 k，二进制字符串  Sn 的形成规则如下：
 * <p>
 * S1 = "0"
 * 当 i > 1 时，Si = Si-1 + "1" + reverse(invert(Si-1))
 * 其中 + 表示串联操作，reverse(x) 返回反转 x 后得到的字符串，而 invert(x) 则会翻转 x 中的每一位（0 变为 1，而 1 变为 0）
 * <p>
 * 例如，符合上述描述的序列的前 4 个字符串依次是：
 * <p>
 * S1 = "0"
 * S2 = "011"
 * S3 = "0111001"
 * S4 = "011100110110001"
 * 请你返回  Sn 的 第 k 位字符 ，题目数据保证 k 一定在 Sn 长度范围以内。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 3, k = 1
 * 输出："0"
 * 解释：S3 为 "0111001"，其第 1 位为 "0" 。
 * 示例 2：
 * <p>
 * 输入：n = 4, k = 11
 * 输出："1"
 * 解释：S4 为 "011100110110001"，其第 11 位为 "1" 。
 * 示例 3：
 * <p>
 * 输入：n = 1, k = 1
 * 输出："0"
 * 示例 4：
 * <p>
 * 输入：n = 2, k = 3
 * 输出："1"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 20
 * 1 <= k <= 2n - 1
 */
public class FindKthBit {

    public char findKthBit(int n, int k) {
        String[] strings = new String[n];
        strings[0] = "0";
        for (int i = 1; i < strings.length; i++) {
            strings[i] = strings[i - 1] + "1" + reverse(invert(strings[i - 1]));
        }
        return strings[n - 1].charAt(k - 1);
    }

    public String invert(String str) {
        StringBuilder result = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c == '0')
                result.append('1');
            else if (c == '1')
                result.append("0");
        }
        return result.toString();
    }

    public String reverse(String str) {
        StringBuilder stringBuilder = new StringBuilder(str);
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        FindKthBit bit = new FindKthBit();
        System.out.println(bit.findKthBit(2, 3));
    }
}
