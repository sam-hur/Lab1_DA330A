package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;

import util.Data;

public class EchoServer {
    Data data;

    public EchoServer() {
        data = new Data();
    }

    public void establish() {
        ServerSocket serverSocket = null;
        InetAddress serverAddress;
        int PORT = 1234;


        try {
            serverSocket = new ServerSocket(PORT);
        } catch (IOException e) {
            System.out.printf("Could not listen on port: %d%n", PORT);
            System.exit(-1);
        } finally {  // ensure that the port is correctly set
            assert Objects.requireNonNull(serverSocket).getLocalPort() == PORT;
        }

        System.out.println(serverSocket.getInetAddress().getHostAddress());

        Socket clientSocket = null;

        try {
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.out.println("Accept failed: 1234");
            System.exit(-1);
        }
        PrintWriter out = null;
        BufferedReader in = null;
        try {
            out = new PrintWriter(
                    clientSocket.getOutputStream(), true);
            in = new BufferedReader(
                    new InputStreamReader(
                            clientSocket.getInputStream()));
        } catch (IOException ioe) {
            System.out.println("Failed in creating streams");
            System.exit(-1);
        }
        String inputLine, outputLine;
        try {
            while ((inputLine = in.readLine()) != null) {
                out.println(inputLine);
                if (inputLine.equals("Bye."))
                    break;
            }
        } catch (IOException ioe) {
            System.out.println("Failed in reading, writing");
            System.exit(-1);
        }
        try {
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            System.out.println("Could not close");
            System.exit(-1);
        }
    }
}
