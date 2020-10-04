package com.at.wangxu.leetcode;

/**
 * 树状数组
 */
public class FenWickTree {
    int[] sum_;

    public FenWickTree(int n) {
        this.sum_ = new int[n+1];
    }

    public void update(int i,int delta){
        while (i < sum_.length){
            sum_[i] += delta;
            i += i& -i;
        }
    }

    public int query(int i){
        int sum = 0;
        while (i > 0){
            sum += sum_[i];
            i -= i&-i;
        }
        return sum;
    }

    public int sumRange(int i,int j){
        return query(j+1)-query(i);
    }

    public static void main(String[] args) {
        FenWickTree tree = new FenWickTree(3);

        int[] arr = new int[]{1, 3, 5};
        for (int i = 0; i < arr.length; i++) {
            tree.update(i+1, arr[i]);
        }

        System.out.println(tree.sumRange(0, 2));
    }
}
