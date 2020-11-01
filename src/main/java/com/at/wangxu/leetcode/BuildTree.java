package com.at.wangxu.leetcode;

import java.util.Arrays;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 * <p>
 * 注意:
 * 你可以假设树中没有重复的元素。
 * <p>
 * 例如，给出
 * <p>
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 */
public class BuildTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int[] ints;
    int offset = 0;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int max = 0;
        int min = 0;
        for (int j : inorder) {
            max = Math.max(max, j);
            min = Math.min(min, j);
        }
        if (min < 0 )
            offset = Math.abs(min);
        ints = new int[max + offset + 1];

        for (int i = 0; i < inorder.length; i++) {
            ints[inorder[i] + offset ] = i;
        }

        return dfs(inorder, postorder);
    }

    public TreeNode dfs(int[] inorder, int[] postorder){
        if (inorder.length != postorder.length || inorder.length == 0)
            return null;
        //find root index
        int rootIndexInOrder = ints[postorder[postorder.length - 1] + offset];

        TreeNode node = new TreeNode(postorder[postorder.length - 1]);

        node.left = buildTree(Arrays.copyOfRange(inorder, 0, rootIndexInOrder), Arrays.copyOfRange(postorder, 0, rootIndexInOrder));
        node.right = buildTree(Arrays.copyOfRange(inorder, rootIndexInOrder + 1, inorder.length), Arrays.copyOfRange(postorder, rootIndexInOrder, postorder.length - 1));
        return node;
    }

    public static void main(String[] args) {
        BuildTree tree = new BuildTree();

//        TreeNode treeNode = tree.buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
        TreeNode treeNode = tree.buildTree(new int[]{-1}, new int[]{-1});
//        Arrays.stream(Arrays.copyOfRange(a, 0, 1)).forEach(System.out::println);
//        Arrays.stream(Arrays.copyOfRange(a, 1 + 1, a.length)).forEach(System.out::println);

        print(treeNode);
    }

    private static void print(TreeNode treeNode) {
        if (treeNode == null)
            return;
        System.out.println((treeNode.val));
        print(treeNode.left);
        print(treeNode.right);
    }

}
