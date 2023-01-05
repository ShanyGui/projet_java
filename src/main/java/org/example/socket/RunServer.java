package org.example.socket;

import java.io.IOException;

public class RunServer {
    public static void main(String[] args) throws IOException {
        Server server=new Server();
        server.connect("127.0.0.1",6666);
        server.nextMessage();
        server.sendMessage("hello client");
        server.sendMessage("Over");
        server.disconnect();

    }

}
