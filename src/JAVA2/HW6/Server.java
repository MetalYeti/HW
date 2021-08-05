/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JAVA2.HW6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(8189)) {
            System.out.println("Ждем клиента...");

            Socket socket = server.accept();
            System.out.println("Клиент подключился");

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
                            System.out.println("Клиент отключился.");
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
