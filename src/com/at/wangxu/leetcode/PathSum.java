package com.at.wangxu.leetcode;

import java.util.*;

/**
 * 113. 路径总和 II
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 * 返回:
 * <p>
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 */
public class PathSum {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int s = 0;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null)
            return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        this.s = sum;
        dfs(root, new LinkedList<>(), result);
        return result;
//        return bfs(root, sum);
    }

    public void dfs(TreeNode root,LinkedList<Integer> curr,List<List<Integer>> result){

        curr.add(root.val);
        if (root.left == null && root.right == null){
            int count = 0;
            for (Integer integer : curr) {
                count += integer;
            }
            if (count == this.s) {
                result.add(new ArrayList<>(curr));
            }
            return;
        }
        if (root.left != null){
            dfs(root.left,curr,result);
            if (curr.size() > 0)
                curr.removeLast();
        }
        if (root.right != null){
            dfs(root.right, curr, result);
            if (curr.size() > 0)
                curr.removeLast();
        }
    }

    public List<List<Integer>> bfs(TreeNode root, int sum) {
        if (root == null)
            return new ArrayList<>();
        //存储每个节点所对应父节点的路径
        Map<TreeNode, List<Integer>> map = new HashMap<>();
        //bfs queue
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        map.put(root, new ArrayList<>());

        List<List<Integer>> lists = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                List<Integer> list = new ArrayList<>(map.get(poll));
                assert poll != null;
                list.add(poll.val);
                if (poll.left != null) {

                    map.put(poll.left, list);
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    map.put(poll.right, list);
                    queue.add(poll.right);
                }
                //叶子节点
                if (poll.left == null && poll.right == null) {
                    lists.add(new ArrayList<>(list));
                }
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        for (List<Integer> list : lists) {
            int count = 0;
            for (Integer integer : list) {
                count += integer;
            }
            if (count == sum)
                result.add(list);
        }
        return result;
    }

    public static void main(String[] args) {
        PathSum pathSum = new PathSum();

        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(4);
        node.right = new TreeNode(8);
        node.left.left = new TreeNode(11);
        node.left.left.left = new TreeNode(7);
        node.left.left.right = new TreeNode(2);
        node.right.left = new TreeNode(13);
        node.right.right = new TreeNode(4);
        node.right.right.left = new TreeNode(5);
        node.right.right.right = new TreeNode(1);

        pathSum.pathSum(node, 22).forEach(list -> {
            list.forEach(System.out::print);
            System.out.println();
        });
    }
}
