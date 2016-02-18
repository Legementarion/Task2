package com.company.ClientServer;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;

public class ServerL implements Runnable{
	
	private ObjectOutputStream output;
	private ObjectInputStream input;
	private ServerSocket server;
	private Socket connection;
//	private boolean isRunning = true;
	
	@Override
	public void run() {
		ServerStarter();
	}
	
	public void ServerStarter(){
		try{
			server = new ServerSocket(1115, 100);
			while (true) {
				connection = server.accept();
				output = new ObjectOutputStream(connection.getOutputStream());
				output.flush();
				input = new ObjectInputStream(connection.getInputStream());
				String massage = input.readObject().toString();
				executeQuerry(massage);
				output.writeObject(massage +" -answer");
				output.flush();
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close();
		}
	}
	
	private void close() {
		try{
			output.close();
			input.close();
			connection.close();
//			isRunning = false;
		}catch(Exception e){e.printStackTrace();}
	}

	public String executeQuerry(String message) {

	return message;
	}
}
