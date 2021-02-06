package com.at.wangxu.competition;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CountStudents {

    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> queue = new LinkedList<>();
        Arrays.stream(students).forEach(queue::offer);
        int index = 0;
        int count = 0;
        while (queue.size() > 0 && count < queue.size()) {
            Integer poll = queue.poll();
            if (poll == sandwiches[index]) {
                index ++;
                count = 0;
            }else {
                queue.offer(poll);
                count ++;
            }
        }
        return queue.size();
    }

}
