package com.at.wangxu.competition;

/**
 * 5620. 连接连续二进制数字
 */
public class ConcatenatedBinary {
    static final int mod = 1000000007;

    public int concatenatedBinary(int n) {
        long size = 0, result = 0;
		for (int i = 1; i <= n; i++) {
			if ((i & (i - 1)) == 0) {
				size += 1;
			}
			result = ((result << size) | i) % mod;
		}
		return (int) result;
    }

    public static void main(String[] args) {
        ConcatenatedBinary binary = new ConcatenatedBinary();
        // System.out.println(binary.concatenatedBinary(1));
        System.out.println(binary.concatenatedBinary(3));
        System.out.println(binary.concatenatedBinary(12));
        // System.out.println(binary.concatenatedBinary(42));
    }
}
