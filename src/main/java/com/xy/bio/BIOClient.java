package com.xy.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

public class BIOClient {
    public static void main (String[] args) throws IOException{
                Socket socket = new Socket("127.0.0.1",8000);

                //启动一个线程接受数据
                new Thread(() -> {
                    try {
                        while (true){
                            InputStream inputStream = socket.getInputStream();
                            int len;
                            byte[] buf = new byte[1024];
                            while((len = inputStream.read(buf)) != -1){
                                System.out.println(new String(buf,0,len));
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }).start();

                //启动写线程
                new Thread(() -> {
                    String str = "";
                    Scanner scanner = new Scanner(System.in);
                    while (!"over".equals(str)){
                        str = scanner.next();
                        try {
                            socket.getOutputStream().write(str.getBytes());
                            socket.getOutputStream().flush();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
    }
}
