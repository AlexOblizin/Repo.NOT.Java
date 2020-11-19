package src;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String args[]) {
        try {
            ServerSocket serverSocket = new ServerSocket(9000);
            do {
                System.out.println("Ожидание...");
//                serverSocket.setSoTimeout(30000);
                Socket client = serverSocket.accept();
                System.out.println("Подключено!");

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
                String string2Reverse = bufferedReader.readLine();
                StringBuffer stringBuffer = new StringBuffer(string2Reverse);
                String reversedString = stringBuffer.reverse().toString();

                Tools.sendMessage(client, reversedString);
                client.close();

            }while (true);
//            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
