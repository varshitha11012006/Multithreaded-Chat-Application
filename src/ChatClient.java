import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class ChatClient {

    public static void main(String[] args) {

        try {

            Socket s = new Socket("localhost", 5000);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(s.getInputStream()));

            PrintWriter out = new PrintWriter(
                    s.getOutputStream(), true);

            Scanner sc = new Scanner(System.in);

            System.out.println("Connected to Chat Server!");

            Thread t = new Thread(() -> {

                try {

                    while (true) {

                        String msg = in.readLine();

                        if (msg == null) {
                            break;
                        }

                        System.out.println("\n" + msg);
                        System.out.print("You: ");
                    }

                } catch (Exception e) {
                    System.out.println("Disconnected from server.");
                }
            });

            t.start();

            while (true) {

                System.out.print("You: ");

                String msg = sc.nextLine();

                if (msg.equalsIgnoreCase("exit")) {
                    break;
                }

                out.println(msg);
            }

            sc.close();
            s.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}