package com.at.wangxu.competition;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 5555. 统计字典序元音字符串的数目 显示英文描述 
通过的用户数0
尝试过的用户数0
用户总通过次数0
用户总提交次数0
题目难度Medium
给你一个整数 n，请返回长度为 n 、仅由元音 (a, e, i, o, u) 组成且按 字典序排列 的字符串数量。

字符串 s 按 字典序排列 需要满足：对于所有有效的 i，s[i] 在字母表中的位置总是与 s[i+1] 相同或在 s[i+1] 之前。

 

示例 1：

输入：n = 1
输出：5
解释：仅由元音组成的 5 个字典序字符串为 ["a","e","i","o","u"]
示例 2：

输入：n = 2
输出：15
解释：仅由元音组成的 15 个字典序字符串为
["aa","ae","ai","ao","au","ee","ei","eo","eu","ii","io","iu","oo","ou","uu"]
注意，"ea" 不是符合题意的字符串，因为 'e' 在字母表中的位置比 'a' 靠后
示例 3：

输入：n = 33
输出：66045
 

提示：

1 <= n <= 50 
 */
public class CountVowelStrings {
    static List<Character> Vowel = new ArrayList<>(Arrays.asList('a','e','i','o','u'));

    public int countVowelStrings(int n) {
        List<List<Character>> list = new LinkedList<>();

        dfs(list,0,new ArrayDeque<Character>(n),Vowel,n);

        //
        // for (List<Character> list2 : list) {
        //     for (Character c : list2) {
        //         System.out.print(c);
        //     }
        //     System.out.println();
        // }
        return list.size();
    }

    private void dfs(List<List<Character>> list, int start ,ArrayDeque<Character> current, List<Character> param, int n) {
        if (n == 0) {
            list.add(new ArrayList<>(current));
            return;
        }

        for (int i = start ; i < param.size(); i++) {
            // Character remove = param.remove(i);
            Character select =  param.get(i);

            current.addLast(select);

            dfs(list,i,current, param, n - 1);

            // param.add(i, remove);
            current.removeLast();
        }

    }

    public static void main(String[] args) {
        CountVowelStrings countVowelStrings = new CountVowelStrings();
        // System.out.println(countVowelStrings.countVowelStrings(1));
        System.out.println(countVowelStrings.countVowelStrings(2));
        System.out.println(countVowelStrings.countVowelStrings(33));
    }
}
