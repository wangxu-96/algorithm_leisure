package com.at.util;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class FileUtil {

    //create file for character
    public static void createFile(String fileName) throws IOException {
        FileWriter fw = new FileWriter(fileName);
        BufferedWriter bufferedWriter = new BufferedWriter(fw);

        for (int i = 0; i < 10000000; i++) {
            if (i != 0)
                bufferedWriter.newLine();
            bufferedWriter.write("test" + (int) (Math.random() * 10000000));
        }

        if (bufferedWriter != null)
            bufferedWriter.close();
        if (fw != null)
            fw.close();
    }

    //find repeat string
    public static void findRepeat(String fileName) throws IOException {
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        Map<String, Integer> count = new HashMap<>();
        String s;
        while ((s = bufferedReader.readLine()) != null) {
            if (count.containsKey(s)) {
                count.put(s, count.get(s) + 1);
            } else {
                count.put(s, 1);
            }
        }
       /* for (String key : count.keySet()) {
            if (count.get(key) != 1) {
                System.out.println("key:  " + key + " count:  " + count.get(key));
            }
        }*/
        System.out.println("总共重复key个数:" + count.size());
        if (bufferedReader != null) {
            bufferedReader.close();
        }
        if (fileReader != null) {
            fileReader.close();
        }
    }


}
