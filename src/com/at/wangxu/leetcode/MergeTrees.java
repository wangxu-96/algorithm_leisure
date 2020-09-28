package com.at.wangxu.leetcode;

public class MergeTrees {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null)
            return t2;
        else if (t2 == null)
            return t1;

        TreeNode merged = new TreeNode(t1.val + t2.val);
        merged.left = mergeTrees(t1.left, t2.left);
        merged.right = mergeTrees(t1.right, t2.right);
        return merged;
    }

    public static void main(String[] args) {
        MergeTrees mergeTrees = new MergeTrees();

        TreeNode node1 = new TreeNode(1);
        node1.left = new TreeNode(3);
        node1.left.left = new TreeNode(5);
        node1.right = new TreeNode(3);

        TreeNode node2 = new TreeNode(2);
        node2.left = new TreeNode(1);
        node2.left.left = new TreeNode(4);
        node2.right = new TreeNode(3);
        node2.right.right = new TreeNode(7);

        TreeNode node = mergeTrees.mergeTrees(node1, node2);
        print(node);
    }

    private static void print(TreeNode node) {
        if (node == null)
            return;
        System.out.println(node.val);
        print(node.left);
        print(node.right);
    }
}
