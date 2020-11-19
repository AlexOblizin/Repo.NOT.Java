package src;

import java.io.*;
import java.net.Socket;

public class Tools {
    public static void sendMessage(Socket socket, String msg) throws IOException {

        OutputStream outputStream = socket.getOutputStream();
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
        bufferedWriter.write(msg + "\n");
        bufferedWriter.flush();
        System.out.println("Сообщение: \"" + msg + "\" - успешно отправлено");

    }

    public static String receiveMessage(Socket socket) throws IOException {

        InputStream inputStream = socket.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String msg = bufferedReader.readLine();
        return msg;

    }

}
