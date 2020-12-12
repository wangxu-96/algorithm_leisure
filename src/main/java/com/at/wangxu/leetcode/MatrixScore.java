package com.at.wangxu.leetcode;

/**
 * 
 */
public class MatrixScore {

    // 最左边的列应该为1 如果不是则翻转该行
    // 对于列 1的个数应该更多
    public int matrixScore(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        for (int i = 0; i < m; i++) {
            if (A[i][0] == 0) {
                // 翻转
                for (int j = 0; j < n; j++) {
                    if (A[i][j] == 0)
                        A[i][j] = 1;
                    else
                        A[i][j] = 0;
                }
            }
        }

        for (int j = 0; j < n; j++) {
            int zeroCount = 0;
            int oneCount = 0;
            for (int i = 0; i < m; i++) {
                if (A[i][j] == 0)
                    zeroCount++;
                else
                    oneCount++;
            }
            if (zeroCount > oneCount) {
                for (int i = 0; i < m; i++) {
                    if (A[i][j] == 1)
                        A[i][j] = 0;
                    else
                        A[i][j] = 1;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            int current = 0;
            for (int j = 0; j < n; j++) {
                current += A[i][j] << n - 1 - j;
            }
            res += current;
        }
        return res;
    }

    public static void main(String[] args) {
        MatrixScore matrixScore = new MatrixScore();
        // System.out.println(matrixScore.matrixScore(new int[][] { { 1,1 }, { 0,0 }, {
        // 1,0}, { 1,0} , { 1,1} }));
        System.out.println(matrixScore.matrixScore(new int[][] { { 0, 0, 1, 1 }, { 1, 0, 1, 0 }, { 1, 1, 0, 0 } }));
    }
}
