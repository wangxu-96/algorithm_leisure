package com.at.wangxu.tree;

public class BinaryTree {



    public static void main(String[] args){
        //根节点-->10
        TreeNode treeNode1 = new TreeNode(10);

        //左孩子-->9
        TreeNode treeNode2 = new TreeNode(9);

        //右孩子-->20
        TreeNode treeNode3 = new TreeNode(20);

        //20的左孩子-->15
        TreeNode treeNode4 = new TreeNode(15);

        //20的右孩子-->35
        TreeNode treeNode5 = new TreeNode(35);

        //根节点的左右孩子
        treeNode1.setLefTreeNode(treeNode2);
        treeNode1.setRightNode(treeNode3);

        //20节点的左右孩子
        treeNode3.setLefTreeNode(treeNode4);
        treeNode3.setRightNode(treeNode5);
        System.out.println("中序遍历-----");
        inTraverseBTree(treeNode1);
        System.out.println("先序遍历-----");
        preTraverBTree(treeNode1);
        System.out.println("后序遍历-----");
        afTraverBTree(treeNode1);
    }

    /**
     * 中序遍历,递归
     * @param treeNode
     */
    public static void inTraverseBTree(TreeNode treeNode){
        if (treeNode!=null){
            //先访问左节点
            inTraverseBTree(treeNode.getLefTreeNode());
            //再访问根结点
            System.out.println(treeNode.getValue());
            //最后访问右节点
            inTraverseBTree(treeNode.getRightNode());
        }
    }

    /**
     * 先序遍历，递归
     * @param treeNode
     */
    public static void preTraverBTree(TreeNode treeNode){
        if (treeNode!=null){
            //先访问根结点
            System.out.println(treeNode.getValue());
            //再访问左节点
            preTraverBTree(treeNode.getLefTreeNode());
            //最后访问右节点
            preTraverBTree(treeNode.getRightNode());
        }
    }

    /**
     * 后序遍历，递归
     * @param treeNode
     */
    public static void afTraverBTree(TreeNode treeNode){
        if (treeNode!=null){
            //先访问左节点
            afTraverBTree(treeNode.getLefTreeNode());
            //再访问右节点
            afTraverBTree(treeNode.getRightNode());
            //最后访问根
            System.out.println(treeNode.getValue());
        }
    }


}
