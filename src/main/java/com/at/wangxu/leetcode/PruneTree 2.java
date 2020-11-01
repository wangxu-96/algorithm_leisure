package com.at.wangxu.leetcode;

/**
 * 814. 二叉树剪枝
 * 
 * 给定二叉树根结点 root ，此外树的每个结点的值要么是 0，要么是 1。
 * 
 * 返回移除了所有不包含 1 的子树的原二叉树。
 * 
 * ( 节点 X 的子树为 X 本身，以及所有 X 的后代。)
 * 
 * 示例1: 输入: [1,null,0,0,1] 输出: [1,null,0,null,1]
 * 
 * 解释: 只有红色节点满足条件“所有不包含 1 的子树”。 右图为返回的答案。
 * 
 * 
 * 示例2: 输入: [1,0,1,0,0,0,1] 输出: [1,null,1,null,1]
 * 
 * 
 * 
 * 示例3: 输入: [1,1,0,1,1,0,1,0] 输出: [1,1,0,1,1,null,1]
 * 
 * 
 * 
 * 说明:
 * 
 * 给定的二叉树最多有 100 个节点。 每个节点的值只会为 0 或 1 。
 * 
 */
public class PruneTree {

    public TreeNode pruneTree(TreeNode root) {
        if (dfs(root)) {
            return null;
        }

        return root;
    }

    private boolean dfs(TreeNode root) {
        if (root == null)
            return true;

        boolean left = dfs(root.left);

        if (left) {
            root.left = null;
        }

        boolean right = dfs(root.right);
        if (right) {
            root.right = null;
        }

        return left && right && root.val == 0;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(0);
        // node.left = new TreeNode(0);
        // node.left.left = new TreeNode(0);
        // node.left.right = new TreeNode(0);

        node.right = new TreeNode(0);
        node.right.left = new TreeNode(0);
        node.right.right = new TreeNode(0);

        PruneTree tree = new PruneTree();
        TreeNode res = tree.pruneTree(node);

        System.out.println(res);
    }

}
