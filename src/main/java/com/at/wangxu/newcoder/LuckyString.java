package com.at.wangxu.newcoder;

import java.util.*;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/9ef1046e746248fe93751e37126bb9e0
 * 来源：牛客网
 * <p>
 * A string s is LUCKY if and only if the number of different characters in s is a fibonacci number. Given a string consisting of only lower case letters , output all its lucky non-empty substrings in lexicographical order. Same substrings should be printed once.
 */
public class LuckyString {
    public static void main(String[] args) {
        //获取输入的字符串
        Scanner scanner=new Scanner(System.in);
        String string=scanner.next();
        scanner.close();

        //斐波拉切数列
        Set<Integer> fibonacci=new HashSet<Integer>();
        for (int i=1;i<=100;i++){
            if (fibonacci(i)>100)
                break;
            fibonacci.add(fibonacci(i));
        }

        //字符串截取
        Set<String> strSet=new HashSet<>();
        for (int i=0;i<string.length();i++){
            for (int j=i;j<string.length();j++){
                strSet.add(string.substring(i,j+1));
            }
        }
        List<String> strList=new ArrayList<>(strSet);
        Collections.sort(strList);
        for (String s: strList) {
                Set<Character> characterSet=new HashSet<>();
                char[] chars=s.toCharArray();
                for (int i=0;i<chars.length;i++){
                    characterSet.add(chars[i]);
                }
                if (fibonacci.contains(characterSet.size())){
                    System.out.println(s);
                }

        }

    }


    private static int fibonacci(int n) {
        if (n == 0)
            return 0;
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
}
