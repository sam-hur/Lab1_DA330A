package server.multiclient;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import server.Server;

public class MultiClientServer extends Thread {
    public MultiClientServer() {
    }

    public void run() {
        ServerSocket serverSocket = null;  // switchboard for handling incoming connections
        int PORT = 2345;
        try {
            serverSocket = new ServerSocket(PORT);  // instantiate switchboard with port number
        } catch (IOException e) {
            System.out.printf("Could not listen on port: %d%n", PORT); // port exists
            System.exit(-1);
        }
        Socket clientSocket = null;  // client side representation of the connection
        while (true) {
            try {
                clientSocket = serverSocket.accept();  // listen & establish a connection. Blocks
                // the program's execution until a client successfully establishes a connection with the server.
                Server server = new Server(clientSocket);
                server.start();
            } catch (IOException e) {
                System.out.printf("Accept failed: %d%n", PORT);
                System.exit(-1);
            }
        }
    }
}
