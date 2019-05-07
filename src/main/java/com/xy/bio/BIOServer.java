package com.xy.bio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class BIOServer {
    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(8000);
        //客户端socket集合
        List<Socket> sockets = new ArrayList<Socket>();
        //启动一个线程去监听客户端
        new Thread(() -> {
            while (true){
                //阻塞方法获取连接
                try {
                    Socket socket = serverSocket.accept();
                    sockets.add(socket);
                    //给每个连接创建一个线程。负责读取数据
                    new Thread(() ->  {
                        byte[] buf = new byte[1024];
                        try {
                            InputStream inputStream = socket.getInputStream();
                                int len;
                                while ((len = inputStream.read(buf)) !=-1){
                                    String message = new String(buf,0,len);
                                    for (Socket socket1 : sockets){
                                        //发送给客户端
                                        OutputStream outputStream = socket1.getOutputStream();
                                        outputStream.write(message.getBytes());
                                        outputStream.flush();
                                        System.out.println(message);
                                    }
                                }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }).start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start(); ;
    }
}
