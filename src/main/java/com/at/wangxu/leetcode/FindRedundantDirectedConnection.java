package com.at.wangxu.leetcode;

import java.util.*;

/**
 * 685. 冗余连接 II
 * 在本问题中，有根树指满足以下条件的有向图。该树只有一个根节点，所有其他节点都是该根节点的后继。每一个节点只有一个父节点，除了根节点没有父节点。
 * <p>
 * 输入一个有向图，该图由一个有着N个节点 (节点值不重复1, 2, ..., N) 的树及一条附加的边构成。附加的边的两个顶点包含在1到N中间，这条附加的边不属于树中已存在的边。
 * <p>
 * 结果图是一个以边组成的二维数组。 每一个边 的元素是一对 [u, v]，用以表示有向图中连接顶点 u 和顶点 v 的边，其中 u 是 v 的一个父节点。
 * <p>
 * 返回一条能删除的边，使得剩下的图是有N个节点的有根树。若有多个答案，返回最后出现在给定二维数组的答案。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [[1,2], [1,3], [2,3]]
 * 输出: [2,3]
 * 解释: 给定的有向图如下:
 * 1
 * / \
 * v   v
 * 2-->3
 * 示例 2:
 * <p>
 * 输入: [[1,2], [2,3], [3,4], [4,1], [1,5]]
 * 输出: [4,1]
 * 解释: 给定的有向图如下:
 * 5 <- 1 -> 2
 * ^    |
 * |    v
 * 4 <- 3
 * 注意:
 * <p>
 * 二维数组大小的在3到1000范围内。
 * 二维数组中的每个整数在1到N之间，其中 N 是二维数组的大小。
 */
public class FindRedundantDirectedConnection {
    private int count;

    public int[] findRedundantDirectedConnection(int[][] edges) {
        for (int i = edges.length - 1; i >= 0; i--) {
            if (valid(edges, i)) {
                return edges[i];
            }
        }
        return null;
    }

    /**
     * 去掉edges二维数组中的第index个,是否可以使剩下节点组成一棵树
     *
     * @param edges edges
     * @param index index
     * @return boolean
     */
    private boolean valid(int[][] edges, int index) {

        int[] degree = new int[edges.length + 1];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            if (i == index)
                continue;
            degree[edges[i][1]]++;
            if (map.containsKey(edges[i][0])) {
                map.get(edges[i][0]).add(edges[i][1]);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(edges[i][1]);
                map.put(edges[i][0], list);
            }
        }

        int root = 0;
        for (int i = 1; i < degree.length; i++) {
            if (degree[i] >= 2)
                return false;
            if (degree[i] == 0)
                root = i;
        }
        if (root == 0 || !map.containsKey(root))
            return false;
        Set<Integer> set = new HashSet<>();
        set.add(root);
        this.count = 1;
        return dfs(set, map, root) && this.count == edges.length;
    }

    private boolean dfs(Set<Integer> set, Map<Integer, List<Integer>> map, int i) {
        if (!map.containsKey(i))
            return true;
        for (Integer integer : map.get(i)) {
            if (set.contains(integer))
                return false;
            set.add(integer);
            this.count++;
            if (!dfs(set, map, integer))
                return false;
        }
        return true;
    }


    public static void main(String[] args) {
        FindRedundantDirectedConnection bean = new FindRedundantDirectedConnection();
        Arrays.stream(bean.findRedundantDirectedConnection(new int[][]{{1, 2}, {1, 3}, {2, 3}})).forEach(System.out::println);
        Arrays.stream(bean.findRedundantDirectedConnection(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 1}, {1, 5}})).forEach(System.out::println);
        Arrays.stream(bean.findRedundantDirectedConnection(new int[][]{{2, 1}, {3, 1}, {4, 2}, {1, 4}})).forEach(System.out::println);
    }
}
