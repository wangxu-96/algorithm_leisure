package com.at.wangxu.leetcode;

import javax.swing.tree.TreeNode;
import java.util.*;

/**
 * 501. 二叉搜索树中的众数
 * <p>
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 * <p>
 * 假定 BST 有如下定义：
 * <p>
 * 结点左子树中所含结点的值小于等于当前结点的值
 * 结点右子树中所含结点的值大于等于当前结点的值
 * 左子树和右子树都是二叉搜索树
 * 例如：
 * 给定 BST [1,null,2,2],
 * <p>
 * 1
 * \
 * 2
 * /
 * 2
 * 返回[2].
 * <p>
 * 提示：如果众数超过1个，不需考虑输出顺序
 * <p>
 * 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
 */
public class FindMode {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    Map<Integer, Integer> map = new HashMap<>();
    int max = 0;
    public int[] findMode(TreeNode root) {
        dfs(root);

        List<Integer> list = new ArrayList<>();
        for (Integer integer : map.keySet()) {
            if (map.get(integer) == max)
                list.add(integer);
        }
        int[] ints = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ints[i] = list.get(i);
        }
        return ints;
    }

    public void dfs(TreeNode node){
        if (node == null)
            return;
        map.put(node.val, map.getOrDefault(node.val,0) + 1);
        max = Math.max(max, map.get(node.val));
        dfs(node.left);
        dfs(node.right);
    }


    public static void main(String[] args) {
        FindMode findMode = new FindMode();
        TreeNode node = new TreeNode(1);
        node.right = new TreeNode(2);
        node.right.left = new TreeNode(2);
        Arrays.stream(findMode.findMode(node)).forEach(System.out::println);
    }
}
