package server;

public class ServerMain extends EchoServer {
    public static void main(String[] args) {
        EchoServer echoServer = new EchoServer();
        System.out.println("\u2714 Starting Server");
        echoServer.establish();
    }
}
