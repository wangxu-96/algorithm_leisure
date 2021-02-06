package com.at.wangxu.competition;

import java.util.*;

/**
 * 5611. 石子游戏 VI
 */
public class StoneGameVI {
    static class Node {
        int index;
        int value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int aliceScore = 0;
        int bobScore = 0;
        int n = aliceValues.length;
        int[] s = new int[n];
        for (int i = 0; i < n; i++) {
            s[i] = aliceValues[i] + bobValues[i];
        }
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>((o1, o2) -> o2.value - o1.value);
        Arrays.sort(s);
        for (int i = 0; i < n / 2; i++) {
            int temp = s[i];
            s[i] = s[n - 1 - i];
            s[n - 1 - i] = temp;
        }
        for (int i = 0; i < n; i++) {
            priorityQueue.add(new Node(i, aliceValues[i] + bobValues[i]));
        }

        for (int i = 0; i < n; i++) {
            Node poll = priorityQueue.poll();
            assert poll != null;
            if ((i & 1) == 0) {
                aliceScore += s[i] - bobValues[poll.index];
            }else {
                bobScore += s[i] - aliceValues[poll.index];
            }
        }
        return Integer.compare(aliceScore, bobScore);
    }

    public static void main(String[] args) {
        StoneGameVI stoneGameVI = new StoneGameVI();
        System.out.println(stoneGameVI.stoneGameVI(new int[]{1, 3}, new int[]{2, 1}));
//        System.out.println(stoneGameVI.stoneGameVI(new int[]{9,9,5,5,2,8,2,4,10,2,3,3,4}, new int[]{9,5,3,4,4,6,6,6,4,3,7,5,10}));
//        System.out.println(stoneGameVI.stoneGameVI(new int[]{2,4,3}, new int[]{1,6,7}));

    }
}
