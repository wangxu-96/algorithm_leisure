package com.at.wangxu.competition;

/**
 * 5605. 检查两个字符串数组是否相等
 */
public class ArrayStringsAreEqual {

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String string : word1) {
            stringBuilder.append(string);
        }

        StringBuilder stringBuilder2 = new StringBuilder();
        for (String string : word2) {
            stringBuilder2.append(string);
        }

        return stringBuilder.toString().equals(stringBuilder2.toString());
    }

    public static void main(String[] args) {
        ArrayStringsAreEqual aEqual = new ArrayStringsAreEqual();
        System.out.println(aEqual.arrayStringsAreEqual(new String[] { "ab", "c" }, new String[] { "a", "bc" }));
        System.out.println(aEqual.arrayStringsAreEqual(new String[] { "a", "cb" }, new String[] { "ab", "c" }));
        System.out
                .println(aEqual.arrayStringsAreEqual(new String[] { "abc", "d", "defg" }, new String[] { "abcddefg" }));
    }
}
