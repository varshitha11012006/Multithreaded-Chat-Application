import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ChatServer {

    static ArrayList<ClientHandler> clients = new ArrayList<>();

    public static void main(String[] args) {

        try {

            ServerSocket ss = new ServerSocket(5000);

            System.out.println("Chat Server Started...");
            System.out.println("Waiting for clients...");

            while (true) {

                Socket s = ss.accept();

                System.out.println("Client connected!");

                ClientHandler ch = new ClientHandler(s);

                clients.add(ch);

                ch.start();
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void broadcast(String msg, ClientHandler sender) {

        for (ClientHandler ch : clients) {

            if (ch != sender) {
                ch.out.println(msg);
            }
        }
    }
}