package org.example;

import lombok.SneakyThrows;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * SOCKET CLIENT
 */

public class SocketClient {

    @SneakyThrows
    public static void main(String[] args) {
        while (true) {
            try (Socket socket = new Socket(InetAddress.getLocalHost().getHostAddress(), 5555)) {
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                String message = "privet";
                writer.write(message);
                writer.flush();
            } catch (Exception e) {
                System.out.println("server is close");
                throw new RuntimeException(e);
            }
        }
    }
}

