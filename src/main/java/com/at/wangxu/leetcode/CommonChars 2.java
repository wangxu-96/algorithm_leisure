package com.at.wangxu.leetcode;

import java.util.*;

/**
 * 1002. 查找常用字符
 * <p>
 * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
 * <p>
 * 你可以按任意顺序返回答案。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：["bella","label","roller"]
 * 输出：["e","l","l"]
 * 示例 2：
 * <p>
 * 输入：["cool","lock","cook"]
 * 输出：["c","o"]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 100
 * 1 <= A[i].length <= 100
 * A[i][j] 是小写字母
 */
public class CommonChars {

    public List<String> commonChars(String[] A) {

        int[] a = new int[26];
        Arrays.fill(a, Integer.MAX_VALUE);
        for (String s : A) {
            int[] b = new int[26];
            char[] chars = s.toCharArray();
            for (char aChar : chars) {
                b[aChar - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                a[i] = Math.min(a[i], b[i]);
            }
        }
        List<String> list = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0)
                continue;
            for (int j = 0; j < a[i]; j++) {
                list.add(String.valueOf((char) (i + 'a')));
            }
        }
        return list;
    }


    public static void main(String[] args) {
        CommonChars commonChars = new CommonChars();

        commonChars.commonChars(new String[]{"bella", "label", "roller"}).forEach(System.out::println);
    }
}
