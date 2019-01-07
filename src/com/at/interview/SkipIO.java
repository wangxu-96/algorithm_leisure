package com.at.interview;

import java.io.*;

public class SkipIO {
    public static void main(String[] args) throws IOException {
        File file=new File("file.txt");
        FileWriter outputStream=new FileWriter(file);
        outputStream.write("0123456789");
        outputStream.close();
        FileReader fileReader=new FileReader(file);
        System.out.println(fileReader.skip(9));
        fileReader.close();
    }
}
