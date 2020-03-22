package com.at.wangxu.leetcode;

/**
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 *
 * 给定 target = 20，返回 false。
 */
public class FindNumberIn2DArray {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {

//        for (int[] ints : matrix) {
//            for (int anInt : ints) {
//                if (anInt == target)
//                    return true;
//            }
//        }
//        return false;
        //从右上角来查找

        if (matrix.length == 0)
            return false;
        int startRow = 0;
        int startCol = matrix[matrix.length-1].length-1;
        while (startRow <= matrix.length-1 && startCol >= 0){
            if (matrix[startRow][startCol] < target){
                startRow ++;
            }else if (matrix[startRow][startCol] > target){
                startCol --;
            }else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        System.out.println(
//                new FindNumberIn2DArray().
//                        findNumberIn2DArray(new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}}, 20));
        System.out.println(
                new FindNumberIn2DArray().
                        findNumberIn2DArray(new int[][]{{-5}}, -5));
    }
}
