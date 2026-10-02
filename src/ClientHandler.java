import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ClientHandler extends Thread {

    Socket s;
    BufferedReader in;
    PrintWriter out;

    ClientHandler(Socket s) {
        this.s = s;
    }

    public void run() {

        try {

            in = new BufferedReader(
                    new InputStreamReader(s.getInputStream()));

            out = new PrintWriter(
                    s.getOutputStream(), true);

            while (true) {

                String msg = in.readLine();

                if (msg == null) {
                    break;
                }

                System.out.println("Client: " + msg);

                ChatServer.broadcast(msg, this);
            }

            s.close();

        } catch (Exception e) {
            System.out.println("Client disconnected.");
        }
    }
}