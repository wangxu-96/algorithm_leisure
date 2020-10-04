package com.at.wangxu.Thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> string1Future=CompletableFuture.supplyAsync(()->{
            System.out.println("doing string1");
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("done string1");
            return "string1";
        });
        CompletableFuture<String> string2Future=CompletableFuture.supplyAsync(()->{
            System.out.println("doing string2");
            try{
                Thread.sleep(2000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("done string2");
            return "string2";
        });
        CompletableFuture.allOf(string1Future,string2Future).join();
        System.out.println(string1Future.get()+" and "+string2Future.get());
    }
}
