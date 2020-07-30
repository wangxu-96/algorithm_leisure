package com.at.wangxu.leetcode;

/**
 * 面试题 04.04. 检查平衡性
 * <p>
 * 实现一个函数，检查二叉树是否平衡。在这个问题中，平衡树的定义如下：任意一个节点，其两棵子树的高度差不超过 1。
 * <p>
 * <p>
 * 示例 1:
 * 给定二叉树 [3,9,20,null,null,15,7]
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回 true 。
 */
public class IsBalanced {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static boolean flag = true;

    public static boolean isBalanced(TreeNode root) {
        dfs(root);
        return flag;
    }

    static int dfs(TreeNode node) {
        //flag为false 代表二叉树不平衡 不需要再循环了
        if (!flag)
            return -1;
        if (node == null)
            return 0;
        //左子树高度
        int left = dfs(node.left);
        //右子树高度
        int right = dfs(node.right);
        if (Math.abs(left - right) > 1)
            flag = false;
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {

    }
}
