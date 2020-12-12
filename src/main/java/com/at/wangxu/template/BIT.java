package com.at.wangxu.template;

/**
 * 树状数组模版
 */
public class BIT {
    int[] tree;
    int n;

    public BIT(int n) {
        this.n = n;
        this.tree = new int[n + 1];
    }

    public static int lowbit(int x) {
        return x & (-x);
    }

    public void update(int x, int d) {
        while (x <= n) {
            tree[x] += d;
            x += lowbit(x);
        }
    }

    public int query(int x) {
        int ans = 0;
        while (x != 0) {
            ans += tree[x];
            x -= lowbit(x);
        }
        return ans;
    }

    // test fenwick tree
    public static void main(String[] args) {
        BIT bit = new BIT(10);
        int[] src = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        for (int i = 0; i < src.length; i++) {
            bit.update(i + 1, src[i]);
        }

        System.out.println(bit.query(1));
        System.out.println(bit.query(2));
        System.out.println(bit.query(3));
        System.out.println(bit.query(4));
        System.out.println(bit.query(5));
        System.out.println(bit.query(6));
        System.out.println(bit.query(7));
        System.out.println(bit.query(8));
        System.out.println(bit.query(9));
        System.out.println(bit.query(10));
        System.out.println(bit.query(10) - bit.query(8));
    }
}
