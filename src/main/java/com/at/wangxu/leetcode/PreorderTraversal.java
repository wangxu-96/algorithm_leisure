package com.at.wangxu.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 144. 二叉树的前序遍历 给定一个二叉树，返回它的 前序 遍历。 示例:
 * 
 * 输入: [1,null,2,3] 1 \ 2 / 3
 * 
 * 输出: [1,2,3] 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
public class PreorderTraversal {

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

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        // dfs(root, list);

        Stack<TreeNode> stack = new Stack<>();

        // stack.push(root);
        while (!stack.isEmpty() || root != null) {
            while (root != null){
                list.add(root.val);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }


        return list;
    }

    
    private void dfs(TreeNode root, List<Integer> list) {
        if (root == null)
            return;
        list.add(root.val);
        dfs(root.left, list);
        dfs(root.right, list);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.right = new TreeNode(2);
        node.right.left = new TreeNode(3);
        
        PreorderTraversal preorderTraversal = new PreorderTraversal();
        List<Integer> list = preorderTraversal.preorderTraversal(node);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

}
