package com.at.wangxu.leetcode;

/**
 * 968. 监控二叉树
 * <p>
 * 给定一个二叉树，我们在树的节点上安装摄像头。
 * <p>
 * 节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。
 * <p>
 * 计算监控树的所有节点所需的最小摄像头数量。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：[0,0,null,0,0]
 * 输出：1
 * 解释：如图所示，一台摄像头足以监控所有节点。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：[0,0,null,0,null,0,null,null,0]
 * 输出：2
 * 解释：需要至少两个摄像头来监视树的所有节点。 上图显示了摄像头放置的有效位置之一。
 * <p>
 * 提示：
 * <p>
 * 给定树的节点数的范围是 [1, 1000]。
 * 每个节点的值都是 0。
 */
public class MinCameraCover {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int count = 0;

    public int minCameraCover(TreeNode root) {
        dfs(root, false);
        return this.count;
    }

    public void dfs(TreeNode node,boolean isCamera){
        if (node == null)
            return;

        if (isCamera){
            dfs(node.left, true);
            dfs(node.right, true);
        }else {
            this.count ++;
            dfs(node.left, false);
            dfs(node.right, false);
        }
    }

    public static void main(String[] args) {
        MinCameraCover cameraCover = new MinCameraCover();

        TreeNode node = new TreeNode(0);
        node.left = new TreeNode(0);
        node.left.left = new TreeNode(0);
        node.left.right = new TreeNode(0);

        System.out.println(cameraCover.minCameraCover(node));


        node = new TreeNode(0);
        node.left = new TreeNode(0);
        node.left.left = new TreeNode(0);
        node.left.left.left = new TreeNode(0);
        node.left.left.left.right = new TreeNode(0);

        System.out.println(cameraCover.minCameraCover(node));

    }
}
