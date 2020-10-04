package com.at.datastructure;

public class MergeTwoList {
    public static void main(String[] args){
        int[] arr1={3,5,8,11};
        int[] arr2={2,6,8,9,11,15,20};
        int[] ss=merge(arr1,arr2);
        for (int i = 0; i < ss.length; i++) {
            System.out.println(ss[i]);
        }
    }


    public static int[] merge(int[] arr1,int[] arr2){
        int[] resultArr=new int[arr1.length+arr2.length];
        int i=0;
        int j=0;
        int k=0;
        while (i<arr1.length&&j<arr2.length){
            if (arr1[i]<=arr2[j]){
                resultArr[k]=arr1[i];
                i++;
            }else {
                resultArr[k]=arr2[j];
                j++;
            }
            k++;
        }
        while (i<arr1.length){
            resultArr[k]=arr1[i];
            i++;
            k++;
        }
        while (j<arr2.length){
            resultArr[k]=arr2[j];
            j++;
            k++;
        }
        return resultArr;
    }
}
