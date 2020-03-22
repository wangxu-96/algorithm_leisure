package com.at.wangxu.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *  重建二叉树
 *  输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 *  前序遍历 preOrder = [3,9,20,15,7]
 *  中序遍历 inorder = [9,3,15,20,7]
 *
 *
 *      3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class ReBuildTree {

    public TreeNode buildTree(int[] preOrder, int[] inorder) {

        if (preOrder.length == 0 || inorder.length == 0)
            return null;

        int rootIndex;
        for (rootIndex = 0; rootIndex < inorder.length; rootIndex++) {
            if (inorder[rootIndex] == preOrder[0]){
                break;
            }
        }

        TreeNode rootNode = new TreeNode(preOrder[0]);

        List<Integer> preLeft = new ArrayList<>();
        List<Integer> preRight = new ArrayList<>();
        List<Integer> inLeft = new ArrayList<>();
        List<Integer> inRight = new ArrayList<>();

        for (int j=0; j<rootIndex; j++)
        {
            preLeft.add(preOrder[j+1]);
            inLeft.add(inorder[j]);
        }
        for (int j=rootIndex+1; j<inorder.length; j++)
        {
            preRight.add(preOrder[j]);
            inRight.add(inorder[j]);
        }

        rootNode.left = buildTree(constructArray(preLeft),constructArray(inLeft));
        rootNode.right = buildTree(constructArray(preRight),constructArray(inRight));

        return rootNode;
    }

    public static int[] constructArray(List<Integer> list){
        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }

    public static void print(TreeNode treeNode){
        if (treeNode != null){
            System.out.println(treeNode.val);
            print(treeNode.left);
            print(treeNode.right);
        }
    }

    public static void main(String[] args) {
        ReBuildTree reBuildTree = new ReBuildTree();

        TreeNode treeNode = reBuildTree.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});

        print(treeNode);
    }


    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
