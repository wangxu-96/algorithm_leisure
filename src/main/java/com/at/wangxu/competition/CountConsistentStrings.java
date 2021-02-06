package com.at.wangxu.competition;

public class CountConsistentStrings {
    public int countConsistentStrings(String allowed, String[] words) {
        int count = 0;
        for (String word : words) {
            boolean f = false;
            for (char c : word.toCharArray()) {
                if (allowed.indexOf(c) == -1) {
                    f = true;
                    break;
                }
            }
            if (!f) {
                count ++;
            }
        }
        return count;
    }
}
