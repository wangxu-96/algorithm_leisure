package com.at.wangxu.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 679. 24 点游戏
 * 你有 4 张写有 1 到 9 数字的牌。你需要判断是否能通过 *，/，+，-，(，) 的运算得到 24。
 *
 * 示例 1:
 *
 * 输入: [4, 1, 8, 7]
 * 输出: True
 * 解释: (8-4) * (7-1) = 24
 * 示例 2:
 *
 * 输入: [1, 2, 1, 2]
 * 输出: False
 * 注意:
 *
 * 除法运算符 / 表示实数除法，而不是整数除法。例如 4 / (1 - 2/3) = 12 。
 * 每个运算符对两个数进行运算。特别是我们不能用 - 作为一元运算符。例如，[1, 1, 1, 1] 作为输入时，表达式 -1 - 1 - 1 - 1 是不允许的。
 * 你不能将数字连接在一起。例如，输入为 [1, 2, 1, 2] 时，不能写成 12 + 12 。
 *
 *
 */
public class JudgePoint24 {
    private static final int TARGET = 24;
    static final double EPSILON = 1e-6;
    private static final int ADD = 0,MULTIPLY = 1,SUBTRACT = 2,DIVIDE = 3;


    /**
     * 每次选取两个数 分别进行 加减乘除 后放入list中，再对list中的数进行递归直到剩余最后一个数字
     * @param nums nums
     * @return boolean
     */
    public boolean judgePoint24(int[] nums) {
        List<Double> doubles = new ArrayList<>();
        for (int num : nums) {
            doubles.add((double) num);
        }
        return solve(doubles);
    }

    private boolean solve(List<Double> doubles) {
        if (doubles.size() == 0)
            return false;
        if (doubles.size() == 1 )
            return Math.abs(doubles.get(0) - TARGET) < EPSILON ;
        for (int i = 0; i < doubles.size(); i++) {
            for (int j = 0; j < doubles.size(); j++) {
                if (i != j){
                    List<Double> list = new ArrayList<>();
                    for (int m = 0; m < doubles.size(); m++) {
                        if (m == i || m == j)
                            continue;
                        list.add(doubles.get(m));
                    }
                    for (int k = 0; k < 4; k++) {
                        if (k < 2 && i > j)
                            continue;
                        if (k == ADD){
                            list.add(doubles.get(i) + doubles.get(j));
                        }else if (k == MULTIPLY){
                            list.add(doubles.get(i) * doubles.get(j));
                        }else if (k == SUBTRACT){
                            list.add(doubles.get(i) - doubles.get(j));
                        }else {
                            if (Math.abs(doubles.get(j)) < EPSILON)
                                return false;
                            list.add(doubles.get(i) / doubles.get(j));
                        }

                        if (solve(list)){
                            return true;
                        }
                        list.remove(list.size() - 1);
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new JudgePoint24().judgePoint24(new int[]{4, 1, 8, 7}));
        System.out.println(new JudgePoint24().judgePoint24(new int[]{1, 2, 1, 2}));
    }
}
