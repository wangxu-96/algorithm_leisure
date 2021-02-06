package com.at.wangxu.competition;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ConstructDistancedSequence {
    int size_ = 0;
    boolean find = false;
    int[] res;

    public int[] constructDistancedSequence(int n) {
        size_ = n;
        if (n == 1) return new int[]{1};
        int[] result = new int[(n - 1) * 2 + 1];
        res = new int[(n - 1) * 2 + 1];
        for (int i = size_; i >= 1 && !find; i--) {
            dfs(result, i, 0, new HashSet<>());
        }
        return res;
    }

    public void dfs(int[] arr, int i, int index, Set<Integer> currentSet) {
        if (currentSet.size() == size_ && !find) {
            find = true;
            System.arraycopy(arr, 0, res, 0, arr.length);
            return;
        }
        if (currentSet.contains(i)) return;
        if (arr[index] != 0) return;
        if (i != 1 && (index + i >= arr.length || arr[index + i] != 0)) return;
        arr[index] = i;
        if (i != 1) {
            arr[index + i] = i;
        }
        currentSet.add(i);

        for (int k = index + 1; k < arr.length && !find; k++) {
            if (arr[k] != 0 ) continue;
            for (int j = size_; j >= 1 && !find ; j--) {
                dfs(arr, j, k, currentSet);
            }
        }
        if (currentSet.size() == size_ && !find) {
            find = true;
            System.arraycopy(arr, 0, res, 0, arr.length);
            return;
        }
        arr[index] = 0;
        if (i != 1) {
            arr[index + i] = 0;
        }
        currentSet.remove(i);
    }


    public static void main(String[] args) {
        ConstructDistancedSequence distancedSequence = new ConstructDistancedSequence();
//        System.out.println(Arrays.toString(distancedSequence.constructDistancedSequence(3)));
        System.out.println(Arrays.toString(distancedSequence.constructDistancedSequence(20)));
    }

}
