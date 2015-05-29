package com.seele.Socket;

import java.net.Socket;
import java.net.ServerSocket;
import java.net.InetAddress;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.io.File;
/**
* 静态Http服务器，动态的在下一章讲解。
**/
public class HttpServer {
 
    public static final String WEB_ROOT = System.getProperty("user.dir") + File.separator + "webroot";
    
    //等待客户端请求
    public void await() {
        ServerSocket serverSocket = null;
        int port = 8080;
        try {
            serverSocket = new ServerSocket(port, 1, InetAddress.getByName("127.0.0.1"));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        while (true) {
            Socket socket = null;
            InputStream input = null;
            OutputStream output = null;
            try {
                socket = serverSocket.accept();
                input = socket.getInputStream();
                output = socket.getOutputStream();
                Request request = new Request(input);
               //解析并处理请求
                request.parse();
                //生成响应
                Response response = new Response(output);
                response.setRequest(request);
                response.sendStaticResource();
                //关闭通道
                socket.close();
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }
        }
    }
    
    public static void main(String[] args) {
        HttpServer server = new HttpServer();
        server.await();
    }
}
