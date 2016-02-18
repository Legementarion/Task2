package com.company.ClientServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by lego on 18.02.16.
 */
public class Client implements Runnable{
    Socket socet;
    private PrintWriter printWriter;
    BufferedReader BR;
    private String buff;


    public void init_connect(){
        try {
            socet = new Socket("127.0.0.1",1115);

            InputStreamReader StreamReader = new InputStreamReader(socet.getInputStream());
            printWriter =new PrintWriter(socet.getOutputStream());
            BR = new BufferedReader(StreamReader);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String getBuff() {
        return buff;
    }

    public void setBuff(String buff) {
        this.buff = buff;
//        mainMenu.setChatArea(buff);
    }

    public PrintWriter getPrintWriter() {
        return printWriter;
    }

    public void setPrintWriter(String str) {
        this.printWriter.println(str);
        printWriter.flush();
    }

    @Override
    public void run() {
        try{
            while ((buff = BR.readLine())!=null){
                setBuff(buff);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
