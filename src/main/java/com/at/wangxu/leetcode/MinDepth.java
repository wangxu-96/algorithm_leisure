package com.at.wangxu.leetcode;

/**
 * 111. 二叉树的最小深度
 */
public class MinDepth {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        return  getMin(root);

    }

    public int getMin(TreeNode root){
        if (root.left == null && root.right == null) {//叶子节点就是1
            return 1;
        }
        int minDepth = Integer.MAX_VALUE;

        if (root.left != null) {
            //左边不为空，递归求左边的最小深度
            minDepth = Math.min(minDepth, getMin(root.left));
        }

        if (root.right != null) {
            //右边不为空，递归求右边的最小深度
            minDepth = Math.min(minDepth, getMin(root.right));
        }
        return minDepth + 1;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
//        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
//        node.right.left = new TreeNode(15);
//        node.right.right = new TreeNode(7);

        System.out.println(new MinDepth().minDepth(node));
    }
}
