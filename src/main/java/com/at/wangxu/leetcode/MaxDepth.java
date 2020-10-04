package com.at.wangxu.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDepth {

    public static int maxDepth(TreeNode root) {
        return root == null? 0 : Math.max(maxDepth(root.left), maxDepth(root.right))+1;
    }

    public static void main(String[] args) {
        TreeNode treeNode = buildNode(new int[]{3,9,20,0,0,15,7});
        System.out.println(maxDepth(treeNode));

    }

    //[]
    //    3
    //   / \
    //  9  20
    //    /  \
    //   15   7
    static TreeNode buildNode(int[] arr){

        Queue<TreeNode> queue = new LinkedList<>();

        int index = 0;
        TreeNode root = new TreeNode(arr[index++]);

        queue.add(root);

        while (!queue.isEmpty() && index < arr.length){
            TreeNode poll = queue.poll();

            poll.left = new TreeNode(arr[index++]);
            if (poll.left.val == 0){
                poll.left = null;
            }else {
                queue.add(poll.left);
            }


            poll.right = new TreeNode(arr[index++]);
            if (poll.right.val == 0){
                poll.right = null;
            }else {
                queue.add(poll.right);
            }
        }

        return root;
    }


    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
