package com.at.wangxu.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 173. 二叉搜索树迭代器
 * 示例：
 * <p>
 * <p>
 * 7
 * 3      15
 * 9       20
 * <p>
 * BSTIterator iterator = new BSTIterator(root);
 * iterator.next();    // 返回 3
 * iterator.next();    // 返回 7
 * iterator.hasNext(); // 返回 true
 * iterator.next();    // 返回 9
 * iterator.hasNext(); // 返回 true
 * iterator.next();    // 返回 15
 * iterator.hasNext(); // 返回 true
 * iterator.next();    // 返回 20
 * iterator.hasNext(); // 返回 false
 *  
 * <p>
 * 提示：
 * <p>
 * next() 和 hasNext() 操作的时间复杂度是 O(1)，并使用 O(h) 内存，其中 h 是树的高度。
 * 你可以假设 next() 调用总是有效的，也就是说，当调用 next() 时，BST 中至少存在一个下一个最小的数。
 * <p>
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
public class BSTIterator {

    //solution 1: 将二叉搜索树中序遍历至数组中，index指向数组开始处，每次next() index++，hashNext()判断index是否是数组最后一个元素
    int index = 0;

    List<TreeNode> list = new ArrayList<>();

    //Solution 2:将二叉搜索树根节点及左节点全部入栈，(stack中最多h个元素，h为树的高度)，
    //每次next() pop一个元素，判断其右结点是否为空，如右结点不为空则将右结点及所有左节点入栈
    Stack<TreeNode> stack = new Stack<>();


//    public BSTIterator(TreeNode root) {
//        inOrder(root);
//    }

//    /**
//     * @return the next smallest number
//     */
//    public int next() {
//        return list.get(index++).val;
//    }
//
//    /**
//     * @return whether we have a next smallest number
//     */
//    public boolean hasNext() {
//        return index != list.size();
//    }

    public BSTIterator(TreeNode node) {
        leftInOrder(node);
    }


    /**
     * @return the next smallest number
     */
    public int next() {
        TreeNode pop = stack.pop();

        if (pop.right != null)
            leftInOrder(pop.right);
        return pop.val;
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    void leftInOrder(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    void inOrder(TreeNode root) {
        if (root == null)
            return;
        inOrder(root.left);
        list.add(root);
        inOrder(root.right);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(7);
        node.left = new TreeNode(3);
        node.right = new TreeNode(15);
        node.right.left = new TreeNode(9);
        node.right.right = new TreeNode(20);

        BSTIterator iterator = new BSTIterator(node);
        while (iterator.hasNext()) {
            int next = iterator.next();
            System.out.println(next);
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
