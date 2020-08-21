package com.at.wangxu.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 98. 验证二叉搜索树
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 *
 *
 */
public class IsValidBST {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int pre;
    boolean isStart = true;
    boolean flag = true;

    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        inOrder(root);
        return flag;
    }

    public boolean bfs(TreeNode node){
        Queue<TreeNode> queue = new LinkedList<>();
        int root = node.val;
        queue.add(node);
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            if (poll.left != null){
                if (poll.left.val >= poll.val || poll.left.val >= root)
                    return false;
                queue.add(poll.left);
            }
            if (poll.right != null){
                if (poll.right.val <= poll.val  || poll.right.val <= root)
                    return false;
                queue.add(poll.right);
            }
        }
        return true;
    }

    public boolean helper(TreeNode node, Integer lower, Integer upper) {
        if (node == null) return true;

        int val = node.val;
        if (lower != null && val <= lower) return false;
        if (upper != null && val >= upper) return false;

        if (! helper(node.right, val, upper)) return false;
        if (! helper(node.left, lower, val)) return false;
        return true;
    }

    public boolean isValidBSTOffical(TreeNode root) {
        return helper(root, null, null);
    }

    public void inOrder(TreeNode treeNode) {

        if (treeNode == null || !flag)
            return;
        inOrder(treeNode.left);
        if (pre >= treeNode.val && !isStart)
            flag = false;
        pre = treeNode.val;
        isStart = false;
        inOrder(treeNode.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(6);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(7);
//        TreeNode root = new TreeNode(2);
//        root.left = new TreeNode(1);
//        root.right = new TreeNode(3);
        System.out.println(new IsValidBST().isValidBSTOffical(root));
    }
}
