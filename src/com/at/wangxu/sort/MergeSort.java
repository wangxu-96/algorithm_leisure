package com.at.wangxu.sort;

import com.at.wangxu.Util.CreateArray;

/**
 * 归并排序
 *
 */
public class MergeSort {


    public static void merSort(int[] arr,int l,int r){
        if (l>=r)
            return;
        int mid=(l+r)/2;
        merSort(arr,l,mid);
        merSort(arr,mid+1,r);
        merge(arr,l,mid,r);

    }

    public static void main(String[] args){
        int n=100000000;
        int[] arr=CreateArray.create(n);
        //CreateArray.printArray(arr);
        long startTime=System.currentTimeMillis();
        merSort(arr,0,n-1);
        long endTime=System.currentTimeMillis();
        System.out.println("\n"+String.valueOf(endTime-startTime));
        //CreateArray.printArray(arr);
    }

    public static void merge(int[] arr,int l,int m,int r){

        int[] temp=new int[r-l+1];

        for (int i = l; i <=r ; i++) {
            temp[i-l]=arr[i];
        }
        int lBegin=l;
        int rBegin=m+1;
        int i=l;
       while(lBegin<=m&&rBegin<=r){
            if (temp[lBegin-l]<temp[rBegin-l]){
                arr[i]=temp[lBegin-l];
                lBegin++;
                i++;
            }
           if (temp[lBegin-l]>=temp[rBegin-l]){
               arr[i]=temp[rBegin-l];
               rBegin++;
               i++;
           }
       }
       while (lBegin<=m){
           arr[i]=temp[lBegin-l];
           lBegin++;
           i++;

       }
        while (rBegin<=r){
            arr[i]=temp[rBegin-l];
            rBegin++;
            i++;
        }

    }





}
