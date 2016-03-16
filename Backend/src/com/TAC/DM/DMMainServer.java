package com.TAC.DM;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class DMMainServer {
	public DMMainServer() {
		// TODO Auto-generated constructor stub
		
		System.out.println(System.getProperty("file.encoding")); //GBK
		System.out.println(System.getProperty("user.language")); //zh
		System.out.println(System.getProperty("user.region")); //CN
		
		try {
			// Create socket for TCP
			ServerSocket server = new ServerSocket(2333);
			System.out.println("TAC-DM Server Start, waitng on Port 2333...");
			
			while (true) {
				//Second socket for data 
				Socket client = server.accept();
				DMService service=new DMService(client);
				Thread serviceThread = new Thread(service);
				serviceThread.start();
			}
			
		} catch (IOException ioe) {
			System.out.println(ioe);
		}

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DMMainServer server = new DMMainServer();
	}

}
