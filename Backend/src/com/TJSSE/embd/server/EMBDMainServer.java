package com.TJSSE.embd.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class EMBDMainServer {
	private ServerSocket server;
	private Integer portNumber;

	public EMBDMainServer(int portNumber) {
		// TODO Auto-generated constructor stub
		
			// Create socket for TCP
			this.portNumber = portNumber;
			try {
				server = new ServerSocket(portNumber);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public void start() {
		System.out.println("EMBD Server Start, waitng on Port " + portNumber + "...");
		while (true) {
			// Second socket for data
			Socket client;
			try {
				client = server.accept();
				EMBDService service = new EMBDService(client);
				Thread serviceThread = new Thread(service);
				serviceThread.start();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EMBDMainServer server = new EMBDMainServer(3623);  // 8222 means 'EMBD'ackend in 9-button keypad
		server.start();
	}

}
