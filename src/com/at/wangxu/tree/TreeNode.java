package com.at.wangxu.tree;

public class TreeNode {
    private TreeNode lefTreeNode;
    private TreeNode rightNode;
    private int value;

    public TreeNode(int value) {
        this.value = value;
    }

    public TreeNode getLefTreeNode() {
        return lefTreeNode;
    }

    public void setLefTreeNode(TreeNode lefTreeNode) {
        this.lefTreeNode = lefTreeNode;
    }

    public TreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(TreeNode rightNode) {
        this.rightNode = rightNode;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
