package MultiClient;

import java.io.*;
import java.net.*;
class MultiClientServer extends Thread
{ public MultiClientServer() {
}
    public void run() {
        ServerSocket serverSocket = null;
        try {
            serverSocket= new ServerSocket(2345);
        }catch (IOException e) {
            System.out.println("Could not listen on port: 2345");
            System.exit(-1);
        }
        Socket clientSocket = null;
        while (true) {
            try {
                clientSocket = serverSocket.accept();
                Server server = new Server(clientSocket);
                server.start();
            } catch (IOException e) {
                System.out.println("Accept failed:2345");
                System.exit(-1);
            }
        }}}