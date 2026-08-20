package com.example;
 
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
 
public class App {
 
    public static void main(String[] args) throws IOException {
 
        HttpServer server =
                HttpServer.create(new InetSocketAddress(8082), 0);
 
        server.createContext("/", exchange -> {
 
            String response =
                    "Hello from Shivam ... Welcome to Docker and Jenkins integration!";
 
            exchange.sendResponseHeaders(200, response.length());
 
            OutputStream outputStream = exchange.getResponseBody();
 
            outputStream.write(response.getBytes());
 
            outputStream.close();
        });
 
        server.start();
 
        System.out.println("Server started on port 8082");
    }
}
