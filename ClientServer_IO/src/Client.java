package src;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    public static void main(String args[]) throws InterruptedException {
        try {


            do {
                Socket socket = new Socket(InetAddress.getLocalHost(), 9000);
                System.out.print("Введите строку: ");
                String outString = new Scanner(System.in).nextLine();

                Tools.sendMessage(socket, outString);

                Thread.sleep(5000);
                String receivedString = Tools.receiveMessage(socket);

                System.out.println("Вернулось с сервера: " + receivedString);
                
                socket.close();

            } while (true);


        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
