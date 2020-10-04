package com.at.wangxu.leetcode;

/**
 * 线段树
 *
 */
public class SegmentTree {

    static final int SIZE = 1000;

    SegmentTreeNode[] segTree = new SegmentTreeNode[SIZE];

    void  build(int root,int[] arr,int start,int end) {

        //叶子节点
        if (start == end)
            segTree[root].val = arr[start];
        else {
            int mid = (start + end) / 2;
            ////递归构造左子树
            build(root * 2 + 1, arr, start, mid);
            ////递归构造右子树
            build(root * 2 + 2, arr, mid + 1, end);
            //根据左右子树根节点的值，更新当前根节点的值
            segTree[root].val = Math.min(segTree[root * 2 + 1].val, segTree[root * 2 + 2].val);
        }
    }

    public static void main(String[] args) {
        SegmentTree segmentTree = new SegmentTree();
        segmentTree.build(0, new int[]{2, 5, 1, 4, 9, 3}, 0, 5);

        for (SegmentTreeNode segmentTreeNode : segmentTree.segTree) {
            System.out.println(segmentTreeNode.val);
        }
    }

    static class SegmentTreeNode{
        int val;
    }
}
