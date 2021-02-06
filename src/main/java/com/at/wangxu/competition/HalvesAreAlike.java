package com.at.wangxu.competition;

import java.util.HashSet;
import java.util.Set;

public class HalvesAreAlike {
    static Set<Character> set = new HashSet<>();
    static {
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
    }
    public boolean halvesAreAlike(String s) {
        return count(s.substring(0,s.length() / 2)) == count(s.substring(s.length()/2));
    }

    private int count(String str) {
        int count = 0;
        for (char c : str.toCharArray()) {
            if (set.contains(c)) count ++;
        }
        return count;
    }
}
