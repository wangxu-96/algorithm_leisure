package com.at.wangxu.leetcode;

/**
 * 647. 回文子串
 * <p>
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 * <p>
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入："abc"
 * 输出：3
 * 解释：三个回文子串: "a", "b", "c"
 * 示例 2：
 * <p>
 * 输入："aaa"
 * 输出：6
 * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
 */
public class CountSubstrings {

    int[][] visited;

    public int countSubstrings1(String s) {
        visited = new int[s.length()][s.length()];
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += sum(i, s);
        }
        sum += s.length();
        return sum;
    }

    public int getSum(int l,int r,String s) {
        int sum = 0;
        while (l >= 0 && r < s.length()) {
            if (s.charAt(l) == s.charAt(r)) {
                if (visited[l][r] == 1) {
                    l--;
                    r++;
                    continue;
                }
                visited[l][r] = 1;
                sum++;
                l--;
                r++;
            } else {
                break;
            }
        }
        return sum;
    }

    private int sum(int i, String s) {
        visited[i][i] = 1;
        int left = getSum(i, i + 1, s);
        int right = getSum(i - 1, i + 1, s);
        return left + right;
    }


    public int countSubstrings(String s) {
        int[][] visited = new int[s.length()][s.length()];
        int n = s.length(), ans = 0;
        for (int i = 0; i < 2 * n - 1; ++i) {
            int l = i / 2, r = i / 2 + i % 2;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                visited[l][r] = 1;
                --l;
                ++r;
                ++ans;
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        CountSubstrings substrings = new CountSubstrings();
//        System.out.println(substrings.countSubstrings("abc"));
//        System.out.println(substrings.countSubstrings("aaa"));
        System.out.println(substrings.countSubstrings("bbccaacacdbdbcbcbbbcbadcbdddbabaddbcadb"));
        System.out.println(substrings.countSubstrings1("bbccaacacdbdbcbcbbbcbadcbdddbabaddbcadb"));
//        System.out.println(substrings.countSubstrings("cbbbc"));
    }
}
