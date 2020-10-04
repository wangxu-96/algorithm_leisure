package com.at.wangxu.newcoder;

import java.util.Arrays;

/**
 * 题目描述
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
public class ReConstructBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre.length != in.length)
            return null;
        if (pre.length == 1)
            return new TreeNode(pre[0]);

        int rootIndex = -1;
        //先找根
        for (int i = 0; i < in.length; i++) {
            if (in[i] == pre[0])
                rootIndex = i;
        }
        if (rootIndex == -1)
            return null;

        TreeNode root = new TreeNode(pre[0]);

        //copyOfRange [from,to)半闭半开区间
        root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, 1 + rootIndex), Arrays.copyOfRange(in, 0, rootIndex));
        root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, rootIndex + 1, pre.length), Arrays.copyOfRange(in, rootIndex + 1, in.length));
        return root;
    }

    public static void main(String[] args) {
        ReConstructBinaryTree reConstructBinaryTree = new ReConstructBinaryTree();
        reConstructBinaryTree.reConstructBinaryTree(new int[]{1, 2, 4, 7, 3, 5, 6, 8}, new int[]{4, 7, 2, 1, 5, 3, 8, 6});
    }
}
