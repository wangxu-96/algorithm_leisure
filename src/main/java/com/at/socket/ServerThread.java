package com.at.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class ServerThread implements Runnable {
    private Socket client=null;
    public ServerThread(Socket socket){
        this.client=socket;
    }
    @Override
    public void run() {
        try {
            PrintStream printStream=new PrintStream(client.getOutputStream());//获取Socket的输出流，用来向客户端发送数据
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(client.getInputStream()));//获取Socket的输入流，用来接收从客户端发送过来的数据
            boolean flag=true;
            while (flag){
                String str=bufferedReader.readLine();//接收从客户端发送过来的数据
                if (str==null||"".equals(str)){
                    flag=false;
                }else {
                    if ("bye".equals(str)){
                        flag=false;
                    }else {
                        printStream.println("echo:"+str);//将接收到的字符串前面加上echo，发送到对应的客户端
                    }
                }
            }
            printStream.close();
            client.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
