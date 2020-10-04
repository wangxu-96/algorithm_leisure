package com.at.wangxu.leetcode;

/**
 * 538. 把二叉搜索树转换为累加树
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 * <p>
 * <p>
 * <p>
 * 例如：
 * <p>
 * 输入: 原始二叉搜索树:
 * 5
 * /   \
 * 2     13
 * <p>
 * 输出: 转换为累加树:
 * 18
 * /   \
 * 20     13
 */
public class ConvertBST {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        dfs(root);
        return root;
    }

    public void dfs(TreeNode node){
        if (node == null)
            return;
        dfs(node.right);
        //
        sum += node.val;
        node.val = sum;
        dfs(node.left);

    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(2);
        node.right = new TreeNode(13);

        ConvertBST convertBST = new ConvertBST();

        print(convertBST.convertBST(node));

    }

    static void print(TreeNode node) {
        if (node == null)
            return;
        print(node.left);
        System.out.println(node.val);
        print(node.right);
    }
}
