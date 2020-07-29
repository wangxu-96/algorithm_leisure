package com.at.wangxu.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1367. 二叉树中的列表
 * <p>
 * 给你一棵以 root 为根的二叉树和一个 head 为第一个节点的链表。
 * <p>
 * 如果在二叉树中，存在一条一直向下的路径，且每个点的数值恰好一一对应以 head 为首的链表中每个节点的值，那么请你返回 True ，否则返回 False 。
 * <p>
 * 一直向下的路径的意思是：从树中某个节点开始，一直连续向下的路径。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：head = [4,2,8], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
 * 输出：true
 * 解释：树中蓝色的节点构成了与链表对应的子路径。
 */
public class IsSubPath {

    public static boolean isSubPath(ListNode head, TreeNode root) {

//        if (root == null)
//            return false;
//        return isSubPathFromRoot(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        while (!queue.isEmpty()){

            TreeNode poll = queue.poll();

            if (isSubPathFromRoot(head, poll))
                return true;
            queue.add(poll.left);
            queue.add(poll.right);
        }
        return false;
    }

    static boolean isSubPathFromRoot(ListNode head,TreeNode root){

        if (head == null)
            return true;
        if (root == null)
            return false;
        if (root.val == head.val)
            return isSubPathFromRoot(head.next, root.left) || isSubPathFromRoot(head.next, root.right);
        return false;
    }

    public static void main(String[] args) {

        TreeNode treeNode = buildNode(new int[]{1, 4, 4, 0, 2, 2, 0, 1, 0, 6, 8, 0, 0, 0, 0, 1, 3});
        ListNode node = new ListNode(4);
        node.next = new ListNode(2);
        node.next.next = new ListNode(8);
        boolean subPath = isSubPath(node, treeNode);
        System.out.println(subPath);

    }

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

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
