package com.at.wangxu.acm;

/**
 * 康托展开
 */
public class Cantor {

    /**
     * 求key在n的全排列升序里的第几位
     *
     * @param n   n
     * @param key key
     * @return 第几位
     */
    public static int kTh(int n, int key) {
        //将key转换成字符串
        StringBuilder stringBuilder = new StringBuilder();
        while (key > 0) {
            stringBuilder.append(key % 10);
            key /= 10;
        }
        stringBuilder.reverse();

        //存储原n排列
        StringBuilder sb = new StringBuilder();
        //阶乘数组
        int[] arr = new int[n + 1];
        arr[0] = 1;
        for (int i = 1; i <= n; i++) {
            sb.append(i);
            arr[i] = arr[i - 1] * i;
        }

        int k = 0;
        for (int i = 1; i <= n; i++) {
            char c = stringBuilder.charAt(i - 1);
            int m = c - '0';
            //find less m count
            int index = 0;
            while (index < sb.length()) {
                if (sb.charAt(index) - '0' == m) {
                    sb.deleteCharAt(index);
                    break;
                }
                index++;
            }
            k += index * arr[n - i];
        }
        return k + 1;
    }

    /**
     * 逆康托展开
     * 长度为n的全排列中第k个数
     *
     * @param n n
     * @param k k
     * @return 第k个数
     */
    public static int inverse(int n, int k) {
        k--;

        //存储原n排列
        StringBuilder sb = new StringBuilder();
        //阶乘数组
        int[] arr = new int[n + 1];
        arr[0] = 1;
        for (int i = 1; i <= n; i++) {
            sb.append(i);
            arr[i] = arr[i - 1] * i;
        }

        int index = 1;
        StringBuilder stringBuilder = new StringBuilder();
        while (index <= n) {
            //比首位小的数有m个
            int m = k / arr[n - index];
            stringBuilder.append(sb.charAt(m));
            sb.deleteCharAt(m);
            k %= arr[n - index];
            index++;
        }
        return Integer.parseInt(stringBuilder.toString());
    }

    public static void main(String[] args) {
        System.out.println(kTh(5, 34152));
        System.out.println(inverse(5, 62));

        System.out.println(Integer.MAX_VALUE);
    }
}
