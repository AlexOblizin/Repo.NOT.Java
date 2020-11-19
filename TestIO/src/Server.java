import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

class Server {

    public static void main(String[] args) {


        try {
            final ServerSocket server = new ServerSocket(9999);
            try (
                    Socket connection = server.accept();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(
                            connection.getInputStream(),
                            StandardCharsets.UTF_8
                    ))) {
                String text;
                while (reader.readLine() != null) {
                    text = reader.readLine();
                    StringBuffer stringBuffer = new StringBuffer(text);
                    text = stringBuffer.reverse().toString();
                    System.out.println(text);
                    if (text.equals("exit")) {
                        break;
                    }

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}