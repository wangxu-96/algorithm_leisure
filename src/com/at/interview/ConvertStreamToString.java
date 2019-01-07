package com.at.interview;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class ConvertStreamToString {
    public static void main(String[] args) throws FileNotFoundException {
        String str=convert(new FileInputStream(new File("/Users/ouakira/Documents/文稿 - Leisure11/idea _workspace/src/com/at/interview/QuickSort.java")));
        System.out.println(str);
    }
    static String convert(InputStream in){
        Scanner scanner=new Scanner(in).useDelimiter("\\A");
        return scanner.hasNext()?scanner.next():"";
    }
}
