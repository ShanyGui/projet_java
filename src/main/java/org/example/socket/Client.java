package org.example.socket;

// A Java program for a Client

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client implements SocketConnection {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

//    public Client(String ip, int port) throws IOException {
//        clientSocket = new Socket(ip, port);
//        out = new PrintWriter(clientSocket.getOutputStream(), true);
//        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
//    }

    public void connect(String ip, int port) throws IOException {
        clientSocket = new Socket(ip, port);
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }

    public void sendMessage(String msg) throws IOException {
        out.println(msg);
        //String resp = in.readLine();
        //return resp;
    }

    @Override
    public String nextMessage() throws IOException {
        // keep reading until "Over" is input
        String line = "";
        while (!line.equals("Over"))
        {
            try
            {
                line = in.readLine();
                System.out.println(line);
            }
            catch(IOException i)
            {
                System.out.println(i);
            }
        }
        return null;
    }

    public void disconnect() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
    }

//    @Test
//    public void givenGreetingClient_whenServerRespondsWhenStarted_thenCorrect() throws IOException {
//        Client client = new Client();
//        client.connect("127.0.0.1", 6666);
//        String response = client.sendMessage("hello server");
//        System.out.println("Envoi du hello server");
//        Assert.assertEquals("hello client", response);
//    }

}