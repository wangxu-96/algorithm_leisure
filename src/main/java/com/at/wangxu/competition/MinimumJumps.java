package com.at.wangxu.competition;

import java.util.HashSet;
import java.util.Set;

/**
 * 5552. 到家的最少跳跃次数
 */
public class MinimumJumps {

    static final int front = 1;
    static final int back = -1;

    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        Set<Integer> exclude = new HashSet<>();

        for (int i = 0; i < forbidden.length; i++) {
            exclude.add(forbidden[i]);
        }

        return dfs(exclude, a, b, x, 0, front, front);
    }

    private int dfs(Set<Integer> exclude, int a, int b, int x, int currentIndex, int preDirect, int direct) {
        if (currentIndex < 0)
            return -1;
        if (exclude.contains(currentIndex))
            return -1;
        if (currentIndex == x)
            return 0;
        if (a > b) {
            if ((currentIndex - x) > b)
                return -1;
            if (preDirect == back && currentIndex > x)
                return -1;
        } else if (a == b) {
            if (x % currentIndex != 0)
                return -1;
        } else {
            if (currentIndex - x > b)
                return -1;
        }

        if (direct == front) {//
            currentIndex += a;
            preDirect = front;
        } else {
            if (preDirect == direct)
                return -1;
            if (currentIndex < b)
                return -1;
            currentIndex -= b;
            preDirect = back;
        }
        int l = dfs(exclude, a, b, x, currentIndex, preDirect, front);
        int r = dfs(exclude, a, b, x, currentIndex, preDirect, back);
        if (l == -1 && r == -1)
            return -1;
        else if (l == -1)
            return r + 1;
        else if (r == -1)
            return l + 1;
        return Math.min(l, r) + 1;
    }

    public static void main(String[] args) {
        MinimumJumps jumps = new MinimumJumps();
        System.out.println(jumps.minimumJumps(new int[] { 14, 4, 18, 1, 15 }, 3, 15,
        9));
        System.out.println(jumps.minimumJumps(new int[] { 8, 3, 16, 6, 12, 20 }, 15,
        13, 11));
        System.out.println(jumps.minimumJumps(new int[] { 1, 6, 2, 14, 5, 17, 4 },
        16, 9, 7));
        System.out.println(jumps.minimumJumps(new int[] { 162, 118, 178, 152, 167, 100, 40, 74, 199, 186, 26, 73, 200,
                127, 30, 124, 193, 84, 184, 36, 103, 149, 153, 9, 54, 154, 133, 95, 45, 198, 79, 157, 64, 122, 59, 71,
                48, 177, 82, 35, 14, 176, 16, 108, 111, 6, 168, 31, 134, 164, 136, 72, 98 }, 29, 98, 80));
    }
}
