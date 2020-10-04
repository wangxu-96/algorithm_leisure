package com.at.leetcode;

public class MedianTwoSortedArrays {

    //main method
    public static void main(String[] args){

        MedianTwoSortedArrays bean = new MedianTwoSortedArrays();

        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        System.out.println(bean.findMedianSortedArrays_ON(nums1,nums2));
        System.out.println(bean.findMedianSortedArrays(nums1,nums2));
    }


    public double findMedianSortedArrays_ON(int[] nums1, int[] nums2){
        double result;
        int[] sum = mergeArrays(nums1,nums2);
        int k = nums1.length + nums2.length;
        if ( k % 2 == 0){
            result =(sum[k/2 -1]+sum[k/2])/2.0;
        }else {
            result = sum[k/2];
        }
        return result;
    }


    public int[] mergeArrays(int[] nums1,int[] nums2){
        int[] arr = new int[nums1.length + nums2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i<= nums1.length-1 || j<= nums2.length-1){
            if (i == nums1.length){
                arr[k] = nums2[j];
                j ++;
                k ++;
                continue;
            }
            if (j == nums2.length){
                arr[k] = nums1[i];
                i ++;
                k ++;
                continue;
            }
            if (nums1[i] <= nums2[j]){
                arr[k] = nums1[i];
                i ++;
            }else {
                arr[k] = nums2[j];
                j ++;
            }
            k ++;
        }

        return arr;
    }


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if (n1 > n2)
            return findMedianSortedArrays(nums2, nums1);

        int k = (n1 + n2 + 1) / 2;
        int l = 0;
        int r = n1;

        while (l < r) {
            int m1 = l + (r - l) / 2;
            int m2 = k - m1;
            if (nums1[m1] < nums2[m2 - 1])
                l = m1 + 1;
            else
                r = m1;
        }

        int m1 = l;
        int m2 = k - l;

        int c1 = Math.max(m1 <= 0 ? Integer.MIN_VALUE : nums1[m1 - 1],
                m2 <= 0 ? Integer.MIN_VALUE : nums2[m2 - 1]);

        if ((n1 + n2) % 2 == 1)
            return c1;

        int c2 = Math.min(m1 >= n1 ? Integer.MAX_VALUE : nums1[m1],
                m2 >= n2 ? Integer.MAX_VALUE : nums2[m2]);

        return (c1 + c2) * 0.5;
    }
}
