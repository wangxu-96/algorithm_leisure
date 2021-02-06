package com.at.wangxu.competition;

public class WaysToSplit {
    static final int MOD = 1000000007;

    public int waysToSplit(int[] nums) {
        long res = 0;
        int n = nums.length;
        int[] v = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            v[i] = v[i - 1] + nums[i - 1];
        }

        for (int i = 1; i < n; i++) {
            if (v[i] * 3 > v[n]) break;
            int l = i + 1;
            int r = n - 1;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (v[n] - v[mid] < v[mid] - v[i]) {
                    r = mid - 1;
                }else {
                    l = mid + 1;
                }
            }

            int ll = i + 1;
            int rr = n - 1;
            while (ll <= rr) {
                int mid = (ll + rr) / 2;
                if (v[mid] - v[i] < v[i]) {
                    ll = mid + 1;
                }else {
                    rr = mid - 1;
                }
            }
            res += l - ll;
        }
        return (int) (res % MOD);
    }

    public static void main(String[] args) {
        WaysToSplit waysToSplit = new WaysToSplit();
        System.out.println(waysToSplit.waysToSplit(new int[]{0, 3, 3}));
        System.out.println(waysToSplit.waysToSplit(new int[]{1, 1, 1}));
        System.out.println(waysToSplit.waysToSplit(new int[]{1, 2, 2, 2, 5, 0}));
        System.out.println(waysToSplit.waysToSplit(new int[]{3, 2, 1}));
    }
}
