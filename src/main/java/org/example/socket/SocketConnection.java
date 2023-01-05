package org.example.socket;

import java.io.IOException;

public interface SocketConnection {

    void connect(String ip, int port) throws IOException;
    void sendMessage(String msg) throws IOException;
    String nextMessage() throws IOException;
    void disconnect() throws IOException;



}
