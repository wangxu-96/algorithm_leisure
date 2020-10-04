package com.at.wangxu.leetcode;

/**
 * 771. 宝石与石头
 *
 * 给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
 *
 * J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
 *
 * 示例 1:
 *
 * 输入: J = "aA", S = "aAAbbbb"
 * 输出: 3
 * 示例 2:
 *
 * 输入: J = "z", S = "ZZ"
 * 输出: 0
 * 注意:
 *
 * S 和 J 最多含有50个字母。
 *  J 中的字符不重复。
 */
public class NumJewelsInStones {

    public int numJewelsInStones(String J, String S) {
        byte[] ints = new byte[58];
        char[] jChar = J.toCharArray();

        for (char c : jChar) {
            ints[c - 'A'] = 1;
        }

        int count = 0;
        char[] sChar = S.toCharArray();
        for (char c : sChar) {
            if (ints[c - 'A'] > 0)
                count ++;
        }
        return count;
    }

    public static void main(String[] args) {
        NumJewelsInStones stones = new NumJewelsInStones();
        System.out.println(stones.numJewelsInStones("aA", "aAAbbbb"));
        System.out.println(stones.numJewelsInStones("z", "ZZ"));
    }
}
