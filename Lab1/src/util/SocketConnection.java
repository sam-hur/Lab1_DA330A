package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketConnection {
    PrintWriter out = null;
    BufferedReader in = null;

    SocketConnection(Socket clientSocket) {
        try {
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(
                    clientSocket.getInputStream()));
        } catch (
                IOException ioe) {
            System.out.println("Failed in creating streams");
            System.exit(-1);
        }
    }


}
