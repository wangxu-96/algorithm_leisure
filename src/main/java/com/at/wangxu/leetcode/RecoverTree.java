package com.at.wangxu.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 99. 恢复二叉搜索树
 * <p>
 * 二叉搜索树中的两个节点被错误地交换。
 * <p>
 * 请在不改变其结构的情况下，恢复这棵树。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,null,null,2]
 * <p>
 *    1
 *   /
 *  3
 *   \
 *    2
 * <p>
 * 输出: [3,1,null,null,2]
 * <p>
 *    3
 *   /
 *  1
 *   \
 *    2
 * 示例 2:
 * <p>
 * 输入: [3,1,4,null,null,2]
 * <p>
 * 3
 * / \
 * 1   4
 *    /
 *   2
 * <p>
 * 输出: [2,1,4,null,null,3]
 * <p>
 * 2
 * / \
 * 1   4
 *    /
 *  3
 */
public class RecoverTree {

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

    public void recoverTree(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();

        inOrder(root, list);

        int m = -1,j=-1;
        for (int i = 0; i < list.size()-1; i++) {
            if (list.get(i).val > list.get(i+1).val ){
                if (m == -1)
                    m = i;
                else
                    j = i;
            }
        }
        if (j == -1){
            //只有一个,交换m 与 m+1
            swapNode(root, list, m, m+1);
        }else {
            //有两个，交换m 与 j+1
            swapNode(root, list, m, j+1);
        }

    }

    /**
     * 交换两个节点
     * @param root root
     * @param root inOrderList
     * @param i i
     * @param j j
     */
    void  swapNode(TreeNode root,List<TreeNode> list,int i,int j){
        int node1 = list.get(i).val;
        int node2 = list.get(j).val;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int count = 0;

        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            if (poll.val == node1){
                poll.val = node2;
                count++;
            }else if (poll.val == node2){
                poll.val = node1;
                count ++;
            }
            if (count == 2)
                break;
            if (poll.left != null)
                queue.add(poll.left);
            if (poll.right != null)
                queue.add(poll.right);
        }

    }

    public void inOrder(TreeNode node, List<TreeNode> nodes){
        if (node == null)
            return;
        inOrder(node.left, nodes);
        nodes.add(node);
        inOrder(node.right, nodes);
    }

    public static void main(String[] args) {
        RecoverTree tree = new RecoverTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        tree.recoverTree(root);
    }
}

