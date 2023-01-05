package org.example.socket;

import java.io.IOException;

public class RunClient {
    public static void main(String args[]) throws IOException {
        Client client = new Client();// "127.0.0.1", 5000
        client.connect("127.0.0.1", 6666);
        client.sendMessage("hello server");
        client.sendMessage("Demande temperature"); // quasi fonctionnelle
        client.sendMessage("Over");
        client.nextMessage();
        client.sendMessage("Over");
        //client.nextMessage();
        client.disconnect();
    }
}
