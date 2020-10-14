package com.at.wangxu.competition;

/**
 * 5537. 分割两个字符串得到回文串
 * <p>
 * 给你两个字符串 a 和 b ，它们长度相同。请你选择一个下标，将两个字符串都在 相同的下标 分割开。由 a 可以得到两个字符串： aprefix 和 asuffix ，满足 a = aprefix + asuffix ，同理，由 b 可以得到两个字符串 bprefix 和 bsuffix ，满足 b = bprefix + bsuffix 。请你判断 aprefix + bsuffix 或者 bprefix + asuffix 能否构成回文串。
 * <p>
 * 当你将一个字符串 s 分割成 sprefix 和 ssuffix 时， ssuffix 或者 sprefix 可以为空。比方说， s = "abc" 那么 "" + "abc" ， "a" + "bc" ， "ab" + "c" 和 "abc" + "" 都是合法分割。
 * <p>
 * 如果 能构成回文字符串 ，那么请返回 true，否则返回 false 。
 * <p>
 * 请注意， x + y 表示连接字符串 x 和 y 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：a = "x", b = "y"
 * 输出：true
 * 解释：如果 a 或者 b 是回文串，那么答案一定为 true ，因为你可以如下分割：
 * aprefix = "", asuffix = "x"
 * bprefix = "", bsuffix = "y"
 * 那么 aprefix + bsuffix = "" + "y" = "y" 是回文串。
 * 示例 2：
 * <p>
 * 输入：a = "abdef", b = "fecab"
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：a = "ulacfd", b = "jizalu"
 * 输出：true
 * 解释：在下标为 3 处分割：
 * aprefix = "ula", asuffix = "cfd"
 * bprefix = "jiz", bsuffix = "alu"
 * 那么 aprefix + bsuffix = "ula" + "alu" = "ulaalu" 是回文串。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= a.length, b.length <= 105
 * a.length == b.length
 * a 和 b 都只包含小写英文字母
 */
public class CheckPalindromeFormation {

    boolean check(String a, String b) {
        int n = a.length();
        for (int i = 0, j = n - 1; i < j; ++i, --j) {
            if (a.charAt(i) != b.charAt(j)) {
                //[i,j]是否组成回文
                return isPalindrome(a.substring(i, j + 1)) || isPalindrome(b.substring(i, j + 1));
            }
        }
        return true;
    }

    boolean checkPalindromeFormation(String a, String b) {
        return check(a, b) || check(b, a);
    }

    public boolean isPalindrome(String s) {

        char[] chars = s.toCharArray();
        int size = chars.length;
        for (int i = 0; i < size / 2; i++) {
            if (chars[i] != chars[size - i - 1])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        CheckPalindromeFormation formation = new CheckPalindromeFormation();
        System.out.println(formation.checkPalindromeFormation("x", "y"));
        System.out.println(formation.checkPalindromeFormation("abdef", "fecab"));
        System.out.println(formation.checkPalindromeFormation("ulacfd", "jizalu"));
        System.out.println(formation.checkPalindromeFormation("askxrrnhyddrlmcgymtichivmwyjfpyqqxmiimxqqypfjywmvihcitmygcmlryczoygimgii",
                "iigmigyozcyfxgfzkwpvjuxbjphbbmwlhdcavhtjhbpccsxaaiyitfbzljvhjoytfqlqrohv"));

    }
}
