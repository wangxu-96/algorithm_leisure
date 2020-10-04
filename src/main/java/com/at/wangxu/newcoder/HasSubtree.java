package com.at.wangxu.newcoder;

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class HasSubtree {

    static class TreeNode {
        int val;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if (root1 == null || root2 ==null)
            return false;
        return check(root1, root2) || HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }

    private boolean check(TreeNode root1, TreeNode root2) {
        if (root2 == null)
            return true;
        if (root1 == null)
            return false;
        return  root1.val == root2.val && check(root1.left, root2.left) && check(root1.right, root2.right);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(8);
        node.left = new TreeNode(8);
        node.right = new TreeNode(7);
        node.left.left = new TreeNode(9);
        node.left.right = new TreeNode(3);
        node.left.right.left = new TreeNode(4);
        node.left.right.right = new TreeNode(7);

        TreeNode node1 = new TreeNode(8);
        node1.left = new TreeNode(9);
        node1.right = new TreeNode(3);

        System.out.println(new HasSubtree().HasSubtree(node, node1));
    }
}
