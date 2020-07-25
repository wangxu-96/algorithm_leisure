package com.at.wangxu.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {


    static TreeNode root = new TreeNode(33);

    public static void main(String[] args) {

        root.lefTreeNode = new TreeNode(16);
        root.lefTreeNode.lefTreeNode = new TreeNode(13);
        root.lefTreeNode.rightNode = new TreeNode(18);
        root.lefTreeNode.lefTreeNode.rightNode = new TreeNode(15);
        root.lefTreeNode.rightNode.lefTreeNode = new TreeNode(17);
        root.lefTreeNode.rightNode.rightNode = new TreeNode(25);
        root.lefTreeNode.rightNode.rightNode.lefTreeNode = new TreeNode(19);
        root.lefTreeNode.rightNode.rightNode.rightNode = new TreeNode(27);

        root.rightNode = new TreeNode(50);
        root.rightNode.lefTreeNode = new TreeNode(34);
        root.rightNode.rightNode = new TreeNode(58);
        root.rightNode.rightNode.lefTreeNode = new TreeNode(51);
        root.rightNode.rightNode.lefTreeNode.rightNode = new TreeNode(55);
        root.rightNode.rightNode.rightNode = new TreeNode(66);




//        insert(9);
//        insert(20);
//        insert(15);
//        insert(35);


        System.out.println("中序遍历-----");
        inTraverseBTree(root);
        System.out.println();
        System.out.println("先序遍历-----");
        preTraverBTree(root);
        System.out.println();
        System.out.println("后序遍历-----");
        afTraverBTree(root);
        System.out.println();
        System.out.println("层级遍历");
        levelOrder(root);

        delete(18);
        delete(13);
        delete(55);
        System.out.println("层级遍历");
        levelOrder(root);
    }

    /**
     * 中序遍历,递归
     *
     * @param treeNode treeNode
     */
    public static void inTraverseBTree(TreeNode treeNode) {
        if (treeNode != null) {
            //先访问左节点
            inTraverseBTree(treeNode.getLefTreeNode());
            //再访问根结点
            System.out.print(treeNode.getValue());
            //最后访问右节点
            inTraverseBTree(treeNode.getRightNode());
        }
    }

    /**
     * 先序遍历，递归
     *
     * @param treeNode treeNode
     */
    public static void preTraverBTree(TreeNode treeNode) {
        if (treeNode != null) {
            //先访问根结点
            System.out.print(treeNode.getValue());
            //再访问左节点
            preTraverBTree(treeNode.getLefTreeNode());
            //最后访问右节点
            preTraverBTree(treeNode.getRightNode());
        }
    }

    /**
     * 后序遍历，递归
     *
     * @param treeNode treeNode
     */
    public static void afTraverBTree(TreeNode treeNode) {
        if (treeNode != null) {
            //先访问左节点
            afTraverBTree(treeNode.getLefTreeNode());
            //再访问右节点
            afTraverBTree(treeNode.getRightNode());
            //最后访问根
            System.out.print(treeNode.getValue());
        }
    }


    /**
     * 层级遍历
     *
     * @param treeNode treeNode
     */
    public static void levelOrder(TreeNode treeNode) {
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(treeNode);

        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            System.out.print(currentNode.getValue());

            if (currentNode.getLefTreeNode() != null) {
                queue.offer(currentNode.getLefTreeNode());
            }

            if (currentNode.getRightNode() != null) {
                queue.offer(currentNode.getRightNode());
            }
        }
    }


    public static void insert(int data) {
        if (root == null) {
            root = new TreeNode(10);
            return;
        }
        TreeNode p = root;

        while (p != null) {
            if (data > p.getValue()) {
                if (p.getRightNode() == null) {
                    p.setRightNode(new TreeNode(data));
                    return;
                }
                p = p.getRightNode();
            } else {
                if (p.getLefTreeNode() == null) {
                    p.setLefTreeNode(new TreeNode(data));
                    return;
                }
                p = p.getLefTreeNode();
            }
        }
    }


    public static void delete(int data) {
        TreeNode p = root; // p指向要删除的节点，初始化指向根节点
        TreeNode pp = null; // pp记录的是p的父节点
        while (p != null && p.value != data) {
            pp = p;
            if (data > p.value)
                p = p.rightNode;
            else
                p = p.lefTreeNode;
        }
        if (p == null) return; // 没有找到

        // 要删除的节点有两个子节点
        if (p.lefTreeNode != null && p.rightNode != null) { // 查找右子树中最小节点
            TreeNode minP = p.rightNode;
            TreeNode minPP = p; // minPP表示minP的父节点
            while (minP.lefTreeNode != null) {
                minPP = minP;
                minP = minP.lefTreeNode;
            }
            p.value = minP.value; // 将minP的数据替换到p中
            p = minP; // 下面就变成了删除minP了
            pp = minPP;
        }

        // 删除节点是叶子节点或者仅有一个子节点
        TreeNode child; // p的子节点
        if (p.lefTreeNode != null)
            child = p.lefTreeNode;
        else if (p.rightNode != null)
            child = p.rightNode;
        else
            child = null;

        if (pp == null)
            root = child; // 删除的是根节点
        else if (pp.lefTreeNode == p)
            pp.lefTreeNode = child;
        else
            pp.rightNode = child;
    }


}
