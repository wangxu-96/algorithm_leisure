package com.at.wangxu.competition;

public class MinCharacters {

    public int minCharacters(String a, String b) {
        int count = 0;

        //a 中的 每个字母 在字母表中 严格小于 b 中的 每个字母 。
        int start = 0;
        char init = 'z';
        while (start < b.length()) {
            if (b.charAt(start) < init) {
                init = b.charAt(start);
            }
            start ++;
        }
        start = 0;
        while (start < a.length()) {
            if (a.charAt(start) >= init) count ++;
            start ++;
        }
        //b 中的 每个字母 在字母表中 严格小于 a 中的 每个字母 。
        int twoSolution = 0;
        start = 0;
        init = 'z';
        while (start < a.length()) {
            if (init > a.charAt(start)) {
                init = a.charAt(start);
            }
            start ++;
        }
        start = 0;
        while (start < b.length()) {
            if (b.charAt(start) >= init) twoSolution ++;
            start ++;
        }
        count = Math.min(twoSolution, count);
        //a 和 b 都 由 同一个 字母组成。
        int thirdSolution = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            char s = (char) (i + 'a');
            //
            int ac = 0;
            for (char c : a.toCharArray()) {
                if (c != s) ac ++;
            }

            for (char c : b.toCharArray()) {
                if (c != s) ac ++;
            }
            thirdSolution = Math.min(thirdSolution, ac);
        }
        return Math.min(thirdSolution, count);
    }

    public static void main(String[] args) {
//        MinCharacters minCharacters = new MinCharacters();
        //System.out.println(minCharacters.minCharacters("da", "cced"));
//        System.out.println(minCharacters.minCharacters("acac", "bd"));
    }
}
