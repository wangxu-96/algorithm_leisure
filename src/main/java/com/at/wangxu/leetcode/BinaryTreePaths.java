package com.at.wangxu.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 257. 二叉树的所有路径
 * <p>
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * <p>
 * 1
 * /   \
 * 2     3
 * \
 * 5
 * <p>
 * 输出: ["1->2->5", "1->3"]
 * <p>
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 */
public class BinaryTreePaths {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    List<String> list = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        pre1(root, new StringBuilder());
        return list;
    }

    public void pre(TreeNode treeNode,StringBuilder stringBuilder){
        if (treeNode == null)
            return;
        if (stringBuilder.length() == 0)
            stringBuilder.append(treeNode.val);
        else
            stringBuilder.append("->").append(treeNode.val);

        if (treeNode.left == null && treeNode.right == null){
            list.add(stringBuilder.toString());
            return;
        }
        if (treeNode.left != null){
            pre(treeNode.left, stringBuilder);
            stringBuilder.delete(stringBuilder.lastIndexOf("->"),stringBuilder.length());
        }
        if (treeNode.right != null){
            pre(treeNode.right, stringBuilder);
            stringBuilder.delete(stringBuilder.lastIndexOf("->"),stringBuilder.length());
        }
    }

    public void pre1(TreeNode treeNode,StringBuilder stringBuilder){
        if (treeNode == null)
            return;
        stringBuilder.append(treeNode.val);

        if (treeNode.left == null && treeNode.right == null){
            list.add(stringBuilder.toString());
            return;
        }
        stringBuilder.append("->");
        if (treeNode.left != null){
            pre1(treeNode.left, new StringBuilder(stringBuilder));
        }
        if (treeNode.right != null){
            pre1(treeNode.right, new StringBuilder(stringBuilder));
        }
    }

    public static void main(String[] args) {
        BinaryTreePaths treePaths = new BinaryTreePaths();
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.right = new TreeNode(5);
        treePaths.binaryTreePaths(treeNode).forEach(System.out::println);
//        StringBuilder stringBuilder = new StringBuilder("1->2->5->3");
//        System.out.println(stringBuilder.delete(stringBuilder.lastIndexOf("->"), stringBuilder.length()));
    }
}
