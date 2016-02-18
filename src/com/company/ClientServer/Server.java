package com.company.ClientServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by lego on 18.02.16.
 */
public class Server {
    ArrayList clientOutputStream;

    public class ClientHandler implements Runnable {
        BufferedReader bufferedReader;
        Socket socket;

        public ClientHandler(Socket clientSoket) {
            try {
                socket = clientSoket;
                InputStreamReader streamReader = new InputStreamReader(socket.getInputStream());
                bufferedReader = new BufferedReader(streamReader);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            String messege;

            try {
                while ((messege = bufferedReader.readLine()) != null) {
                    tellEveryone(messege);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void Connection() {
        clientOutputStream = new ArrayList();
        try {
            ServerSocket serverSocket = new ServerSocket(1115);

            while (true) {
                Socket socket = serverSocket.accept();

                PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
                clientOutputStream.add(printWriter);

                Thread t = new Thread(new ClientHandler(socket));
                t.start();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void tellEveryone(String message) {
        Iterator it = clientOutputStream.iterator();
        while (it.hasNext()) {
            try {
                PrintWriter writer = (PrintWriter) it.next();
                writer.println(message);
                System.out.print(message);
                writer.flush();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}

