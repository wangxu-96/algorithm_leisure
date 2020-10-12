package com.at.wangxu.leetcode;

/**
 * 530. 二叉搜索树的最小绝对差
 * <p>
 * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：
 * <p>
 * 1
 * \
 * 3
 * /
 * 2
 * <p>
 * 输出：
 * 1
 * <p>
 * 解释：
 * 最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
 *  
 * <p>
 * 提示：
 * <p>
 * 树中至少有 2 个节点。
 * 本题与 783 https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/ 相同
 */
public class GetMinimumDifference {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int sub = Integer.MAX_VALUE;
    int pre = -1;
    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        return sub;
    }

    public void dfs(TreeNode treeNode){
        if (treeNode == null)
            return;
        dfs(treeNode.left);
        if (pre != -1) {
            sub = Math.min(sub, Math.abs(treeNode.val - pre));
        }
        pre = treeNode.val;
        dfs(treeNode.right);
    }

    public static void main(String[] args) {
        GetMinimumDifference minimumDifference = new GetMinimumDifference();
        TreeNode node = new TreeNode(543);
        node.left = new TreeNode(384);
        node.left.right = new TreeNode(445);
        node.right = new TreeNode(652);
        node.right.right = new TreeNode(699);
        System.out.println(minimumDifference.getMinimumDifference(node));
    }
}
