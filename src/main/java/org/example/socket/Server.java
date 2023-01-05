package org.example.socket;

// A Java program for a Client

import org.example.temperatures.TemperaturesCRUD;
import org.example.worldcity.WorldCityCRUD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements SocketConnection {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void connect(String ip, int port) throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println("Serveur en attente de connection");
        clientSocket = serverSocket.accept();
        System.out.println("Client accepte");
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        System.out.println("Attente du message du client");
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String greeting = in.readLine();
        System.out.println("Lecture du message du client : ");
        System.out.println(greeting);
        if ("hello server".equals(greeting)) {
            out.println("hello client");
        }
        else {
            out.println("unrecognised greeting");
        }
    }

    @Override
    public void sendMessage(String msg) throws IOException {
        out.println(msg);
        //String resp = in.readLine();
        //return resp;
    }

    @Override
    public String nextMessage() throws IOException {
        // reads message from client until "Over" is sent
        String line = "";
        boolean req = false;
        while (!line.equals("Over"))
        {
            try
            {
                line = in.readLine();
                System.out.println(line);
                if(line == "Demande temperature"){
                    req = true;
                }

            }
            catch(IOException i)
            {
                System.out.println(i);
            }
        }
        if(req){
            TemperaturesCRUD temperaturesCRUD = new TemperaturesCRUD();
            out.println(temperaturesCRUD.readTemperatures(10).toString());
            out.println("Over");
        }

        return null;
    }

    public void disconnect() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();
    }

}
