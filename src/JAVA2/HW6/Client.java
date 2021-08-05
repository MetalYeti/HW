/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JAVA2.HW6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    final static String ADDR = "localhost";
    final static int PORT = 8189;

    public static void main(String[] args) {
        try (Socket socket = new Socket(ADDR, PORT)) {
            System.out.println("Подключились к серверу");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            new Thread(() -> {
                while (!socket.isClosed()) {
                    String str;
                    try {
                        str = in.readUTF();
                        if (str.equals("/end")) {
                            out.writeUTF("/end");
                            socket.close();
                            System.out.println("Сервер отключился");
                        }
                        System.out.println(str);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }).start();

            Scanner sc = new Scanner(System.in);

            while (sc.hasNext() && !socket.isClosed()) {
                try {
                    out.writeUTF(sc.nextLine());
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
