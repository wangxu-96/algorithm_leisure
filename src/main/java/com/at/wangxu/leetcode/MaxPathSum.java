package com.at.wangxu.leetcode;

/**
 * 124. 二叉树中的最大路径和
 * <p>
 * 给定一个非空二叉树，返回其最大路径和。
 * <p>
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * <p>
 * 1
 * / \
 * 2   3
 * <p>
 * 输出: 6
 */
public class MaxPathSum {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static int maxSum = Integer.MIN_VALUE;

    public static int maxPathSum(TreeNode root) {

        getMax(root);
        return maxSum;
    }

    //获取当前节点最大的和
    static int getMax(TreeNode node) {
        if (node == null)
            return 0;
        //左子树最大的和，如果<0则 取0，即不算左子树
        int left = Math.max(getMax(node.left), 0);
        //右子树最大的和，如果<0则 取0，即不算右子树
        int right = Math.max(getMax(node.right), 0);

        //每次找最大的和
        maxSum = Math.max(maxSum, left + right + node.val);

        return Math.max(left, right) + node.val;
    }

    public static void main(String[] args) {

    }
}
