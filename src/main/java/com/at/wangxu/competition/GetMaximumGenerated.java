package com.at.wangxu.competition;

/**
 * 5561. 获取生成数组中的最大值
 */
public class GetMaximumGenerated {
    
    public int getMaximumGenerated(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int max = -1;
        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i <= n; i++) {
            if ( i % 2 == 0 ) {
                arr[i] = arr[ i / 2];
            }else {
                arr[i] = arr[i / 2] + arr[i / 2 + 1];
            }
            max = Math.max(arr[i], max);
        }
        return max;
    }

    public static void main(String[] args) {
        GetMaximumGenerated maximumGenerated = new GetMaximumGenerated();
        System.out.println(maximumGenerated.getMaximumGenerated(7));
        System.out.println(maximumGenerated.getMaximumGenerated(2));
        System.out.println(maximumGenerated.getMaximumGenerated(3));
    }
}
