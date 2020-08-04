package com.at.wangxu.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 226. 翻转二叉树
 * <p>
 * 翻转一棵二叉树。
 * <p>
 * 示例：
 * <p>
 * 输入：
 * <p>
 * 4
 * /   \
 * 2     7
 * / \   / \
 * 1   3 6   9
 * 输出：
 * <p>
 * 4
 * /   \
 * 7     2
 * / \   / \
 * 9   6 3   1
 */
public class InvertTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();

            TreeNode leftNode = poll.left;
            poll.left = poll.right;
            poll.right = leftNode;

            if (poll.left != null)
                queue.add(poll.left);
            if (poll.right != null)
                queue.add(poll.right);
        }
        return root;
    }

    public static void main(String[] args) {
        InvertTree tree = new InvertTree();
        TreeNode treeNode = tree.invertTree(new TreeNode(1));

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(treeNode);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            System.out.println(poll.val);
            if (poll.left != null)
                queue.add(poll.left);
            if (poll.right != null)
                queue.add(poll.right);
        }
    }
}
