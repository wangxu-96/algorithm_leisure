package com.at.wangxu.leetcode;

import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * 763. 划分字母区间
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。返回一个表示每个字符串片段的长度的列表。
 *
 *
 *
 * 示例 1：
 *
 * 输入：S = "ababcbacadefegdehijhklij"
 * 输出：[9,7,8]
 * 解释：
 * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 *
 *
 * 提示：
 *
 * S的长度在[1, 500]之间。
 * S只包含小写字母 'a' 到 'z' 。
 */
public class PartitionLabels {

    static class Node{
        int min;
        int max;

        public Node(int min,int max) {
            this.min = min;
            this.max = max;
        }
    }

    public List<Integer> partitionLabels(String S) {
        Node[] arr = new Node[26];
        char[] chars = S.toCharArray();
        int startIndex = 0;
        for (int i = 0; i < chars.length; i++) {
            if (arr[chars[i] - 'a'] == null)
                arr[chars[i] - 'a'] = new Node(i,i);
            else
                arr[chars[i] - 'a'].max = i;
        }

        int endIndex = arr[chars[startIndex] - 'a'].max;

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < S.length(); i++) {
            endIndex = Math.max(endIndex, arr[S.charAt(i) - 'a'].max);
            if (i == endIndex) {
                list.add(endIndex - startIndex + 1);
                startIndex = endIndex + 1;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        PartitionLabels labels = new PartitionLabels();

        labels.partitionLabels("eccbbbbdec").forEach(System.out::println);
        labels.partitionLabels("ababcbacadefegdehijhklij").forEach(System.out::println);
        labels.partitionLabels("eaaaabaaec").forEach(System.out::println);
    }
}
