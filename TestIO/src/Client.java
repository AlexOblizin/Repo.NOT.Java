import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

final class Client {

    public static void main(String[] args) {


        try (Socket socket = new Socket()) {
            socket.connect(new InetSocketAddress("localhost", 9999), 10000);
            try (PrintWriter writer = new PrintWriter(new OutputStreamWriter(
                    socket.getOutputStream(),
                    StandardCharsets.UTF_8
            ))) {
                Scanner scanner = new Scanner(System.in);
                String str = scanner.nextLine();

                writer.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}