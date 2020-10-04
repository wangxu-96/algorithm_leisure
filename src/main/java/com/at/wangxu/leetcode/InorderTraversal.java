package com.at.wangxu.leetcode;

import java.util.*;

/**
 * 94. 二叉树的中序遍历
 * <p>
 * 给定一个二叉树，返回它的中序 遍历。
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
 * 输出: [1,3,2]
 * 进阶递归算法很简单，你可以通过迭代算法完成吗？
 */
public class InorderTraversal {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
//        dfs(root,list);

        Deque<TreeNode> stk = new LinkedList<>();
        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            list.add(root.val);
            root = root.right;
        }


        return list;
    }

    private void dfs(TreeNode root, List<Integer> objects) {

        if (root == null)
            return;
        dfs(root.left, objects);
        objects.add(root.val);
        dfs(root.right, objects);
    }


    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.right = new TreeNode(2);
        node.right.left = new TreeNode(3);
        new InorderTraversal().inorderTraversal(node).forEach(System.out::println);
    }
}
