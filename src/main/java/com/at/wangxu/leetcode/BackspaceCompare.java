package com.at.wangxu.leetcode;

/**
 * 844. 比较含退格的字符串
 * <p>
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 * <p>
 * 注意：如果对空文本输入退格字符，文本继续为空。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：S = "ab#c", T = "ad#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “ac”。
 * 示例 2：
 * <p>
 * 输入：S = "ab##", T = "c#d#"
 * 输出：true
 * 解释：S 和 T 都会变成 “”。
 * 示例 3：
 * <p>
 * 输入：S = "a##c", T = "#a#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “c”。
 * 示例 4：
 * <p>
 * 输入：S = "a#c", T = "b"
 * 输出：false
 * 解释：S 会变成 “c”，但 T 仍然是 “b”。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= S.length <= 200
 * 1 <= T.length <= 200
 * S 和 T 只含有小写字母以及字符 '#'。
 *  
 * <p>
 * 进阶：
 * <p>
 * 你可以用 O(N) 的时间复杂度和 O(1) 的空间复杂度解决该问题吗？
 */
public class BackspaceCompare {

    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int skipS = 0, skipT = 0;

        while (i >= 0 || j >=0){
            while (i >= 0){
                if (S.charAt(i) == '#'){
                    skipS ++;
                    i --;
                }else if (skipS > 0){
                    skipS --;
                    i --;
                }else {
                    break;
                }
            }

            while (j >= 0){
                if (T.charAt(j) == '#'){
                    skipT ++;
                    j --;
                }else if (skipT > 0){
                    skipT --;
                    j --;
                }else {
                    break;
                }
            }

            if (i >= 0 && j >=0){
                if (S.charAt(i) != T.charAt(j))
                    return false;
            }else {
                if (i >= 0 || j >= 0)
                    return false;
            }
            i --;
            j --;
        }
        return true;
    }


    public static void main(String[] args) {
        BackspaceCompare backspaceCompare = new BackspaceCompare();

        System.out.println(backspaceCompare.backspaceCompare("ab#c", "ad#c"));
        System.out.println(backspaceCompare.backspaceCompare("ab##", "c#d#"));
        System.out.println(backspaceCompare.backspaceCompare("a##c", "#a#c"));
        System.out.println(backspaceCompare.backspaceCompare("a#c", "b"));
    }
}
