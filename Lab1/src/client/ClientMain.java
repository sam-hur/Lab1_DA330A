package client;

public class ClientMain extends EchoClient {
    public static void main(String[] args) {
        EchoClient echoClient = new EchoClient();
        System.out.println("\u2714 Starting Client");
        echoClient.establish();
    }
}
