package com.at.wangxu.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 145. 二叉树的后序遍历
 * <p>
 * 给定一个二叉树，返回它的 后序 遍历。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [3,2,1]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
public class PostorderTraversal {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();

        dfs(root, list);
        return list;
    }

    /**
     * 迭代方式
     *
     * @param root root
     * @param list list
     */
    private void iterator(TreeNode root, LinkedList<Integer> list) {
        Deque<TreeNode> stack = new LinkedList<>();
        if (null == root) return;
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.addFirst(node.val);
            if (null != node.left) {
                stack.push(node.left);
            }
            if (null != node.right) {
                stack.push(node.right);
            }
        }
    }

    /**
     * 递归方式
     *
     * @param root root
     * @param list list
     */
    private void dfs(TreeNode root, List<Integer> list) {
        if (root == null)
            return;
        dfs(root.left, list);
        dfs(root.right, list);
        list.add(root.val);
    }

    public static void main(String[] args) {
        PostorderTraversal postorderTraversal = new PostorderTraversal();

        TreeNode node = new TreeNode(1);
        node.right = new TreeNode(2);
        node.right.left = new TreeNode(3);

        postorderTraversal.postorderTraversal(node).forEach(System.out::println);
    }


}
