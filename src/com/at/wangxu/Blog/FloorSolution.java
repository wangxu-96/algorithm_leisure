package com.at.wangxu.Blog;

import java.util.Scanner;

public class FloorSolution {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.println("输入阶梯数:");
        long n=scanner.nextLong();
        long beginTime1=System.currentTimeMillis();
        System.out.println(Memorandum(n));
        long endTime1=System.currentTimeMillis();
        System.out.println("cost time :"+String.valueOf(endTime1-beginTime1)+"ms");
    }

    private static int AllSolutionRec(int n){
            if (n==1)
                return 1;
            if (n==2)
                return 2;
            if (n==3)
                return 4;
            return AllSolutionRec(n-1)+AllSolutionRec(n-2)+AllSolutionRec(n-3);
        }

    /**
     * 备忘录算法求斐波拉切(arr[i]=arr[i-1]+arr[i-2]+arr[i-3])
     * @param n
     * @return
     */
    private static long Memorandum(long n){
        long[] arr=new long[3];
        arr[0]=1;
        arr[1]=2;
        arr[2]=4;
        for (int i=3;i<n;i++){
            long a=arr[2]+arr[1]+arr[0];
            arr[0]=arr[1];
            arr[1]=arr[2];
            arr[2]=a;
        }
        return arr[2];
    }
}
