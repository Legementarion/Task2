package com.company.ClientServer;

import javax.swing.JOptionPane;

public class Main {
	
	static ServerL server = new ServerL();
	static Connector connector = new Connector();
	static Thread serverThread = new Thread (server);
	
	public static void main(String[] args) throws InterruptedException {	
//		serverThread.start();
		Thread clienrThread = new Thread(connector);
		clienrThread.start();

		String log = JOptionPane.showInputDialog("Input IP");
		connector.con(log);

        boolean ok = true;
		while (ok) {
			String str = JOptionPane.showInputDialog("Input Country");
            if (str.equals("close")){
                ok = false;
                connector.close();
            }else{
                connector.sendMessage(str);
            }
		}
	}			
}
