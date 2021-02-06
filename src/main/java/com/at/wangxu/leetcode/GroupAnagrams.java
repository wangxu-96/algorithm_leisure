package com.at.wangxu.leetcode;

import java.util.*;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strings) {
        Map<Integer, List<String>> map = new HashMap<>();
        for (String str : strings) {
            int hash = hash(str);
            List<String> orDefault = map.getOrDefault(hash, new ArrayList<>());
            orDefault.add(str);
            map.put(hash, orDefault);
        }
        List<List<String>> lists = new ArrayList<>();
        for (Integer integer : map.keySet()) {
            lists.add(map.get(integer));
        }
        return lists;
    }

    private int hash(String string) {
        int[] ints = new int[26];
        for (char c : string.toCharArray()) {
            ints[c - 'a']++;
        }
        StringBuilder s = new StringBuilder();
        for (int anInt : ints) {
            s.append(anInt).append("｜");
        }
        return s.toString().hashCode();
    }

    public static void main(String[] args) {
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        groupAnagrams.groupAnagrams(new String[]{"eat", "tea","src"}).forEach(list -> {
            list.forEach(s -> System.out.print(s + "\t"));
            System.out.println();
        });
    }
}
