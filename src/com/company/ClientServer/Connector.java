package com.company.ClientServer;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import javax.swing.JOptionPane;

public class Connector implements Runnable{

	private static ObjectOutputStream output;
	private static ObjectInputStream input;
	private static Socket connection;
//	private static boolean isRunning = true;

	Connector(String str){
        try {
            connection = new Socket(InetAddress.getByName(str), 1111);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	@Override
	public void run() {
		try {
			while(true){
				output = new ObjectOutputStream(connection.getOutputStream());
				output.flush();
				input = new ObjectInputStream(connection.getInputStream());
				String response = (String)input.readObject();
				System.out.println(response);
				System.out.println("------------------");
			}
//			close();
		}catch(Exception e) {
			e.printStackTrace();
			}
		finally{
			close();
		}
	}

	public void sendMessage(String str){
		try {
			output.flush();
			output.writeObject(str);
			output.flush();

		} catch (Exception e) {e.printStackTrace();}
	}

	public void close() {
		try {
//			isRunning = false;
			output.close();
			input.close();
			connection.close();
		} catch (Exception e) {e.printStackTrace();}
	}

}
