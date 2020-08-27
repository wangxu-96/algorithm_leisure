package com.at.wangxu.leetcode;

import java.util.*;

/**
 * 17. 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 *
 *
 */
public class LetterCombinations {

    static Map<Character,List<String>> keyMap = new HashMap<>();
    static {
        keyMap.put('2', Arrays.asList("a","b","c"));
        keyMap.put('3',Arrays.asList("d","e","f") );
        keyMap.put('4', Arrays.asList("g","h","i"));
        keyMap.put('5', Arrays.asList("j","k","l"));
        keyMap.put('6', Arrays.asList("m","n","o"));
        keyMap.put('7', Arrays.asList("p","q","r","s"));
        keyMap.put('8', Arrays.asList("t","u","v"));
        keyMap.put('9', Arrays.asList("w","x","y","z"));
    }
    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();
        char[] chars = digits.toCharArray();
        for (char aChar : chars) {
            result = getNext(result, aChar);
        }
        return result;
    }

    public List<String> getNext(List<String> list,char a){
        List<String> strings = keyMap.get(a);
        if (list.size() == 0){
            list.addAll(strings);
            return list;
        }
        List<String> result = new ArrayList<>();
        for (String s : list) {
            for (String string : strings) {
                result.add(s + string);
            }
        }
        return result;
    }

    public List<String> letterCombinationsOfficial(String digits) {

        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        dfs(new StringBuilder(), digits, 0, result);
        return result;
    }

    public void dfs(StringBuilder sb,String s,int n,List<String> res){

        if (n == s.length()){
            res.add(sb.toString());
            return;
        }

        List<String> strings = keyMap.get(s.charAt(n));
        for (String string : strings) {
            sb.append(string);
            dfs(sb, s, n + 1, res);
            sb.deleteCharAt(sb.length() - 1);
        }

    }

    public static void main(String[] args) {
        LetterCombinations letterCombinations = new LetterCombinations();

        List<String> strings = letterCombinations.letterCombinationsOfficial("23");

        strings.forEach(System.out::println);
    }
}
