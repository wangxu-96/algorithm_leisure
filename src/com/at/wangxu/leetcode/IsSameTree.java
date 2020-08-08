package com.at.wangxu.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 100. 相同的树
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 * <p>
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * <p>
 * 示例 1:
 * <p>
 * 输入:       1         1
 * / \       / \
 * 2   3     2   3
 * <p>
 * [1,2,3],   [1,2,3]
 * <p>
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:      1          1
 * /           \
 * 2             2
 * <p>
 * [1,2],     [1,null,2]
 * <p>
 * 输出: false
 * 示例 3:
 * <p>
 * 输入:       1         1
 * / \       / \
 * 2   1     1   2
 * <p>
 * [1,2,1],   [1,1,2]
 * <p>
 * 输出: false
 */
public class IsSameTree {

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

    //深度优先，判断p与q是否相等，再递归判断左边和右边
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;
        if (p.val != q.val)
            return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    //广度优先
    public boolean bfs(TreeNode p, TreeNode q) {
        Queue<TreeNode> q1 = new LinkedList<>();
        q1.add(p);
        Queue<TreeNode> q2 = new LinkedList<>();
        q2.add(q);

        while (!q1.isEmpty() && !q2.isEmpty()) {
            TreeNode poll1 = q1.poll();
            TreeNode poll2 = q2.poll();
            if (poll1 == null && poll2 == null)
                continue;
            if (poll1 == null || poll2 == null)
                return false;
            if (poll1.val != poll2.val)
                return false;
            q1.add(poll1.left);
            q1.add(poll1.right);
            q2.add(poll2.left);
            q2.add(poll2.right);
        }
        return q1.isEmpty() && q2.isEmpty();
    }


    public static void main(String[] args) {
        IsSameTree sameTree = new IsSameTree();
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);
        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(3);
        System.out.println(sameTree.bfs(p, q));
    }
}
