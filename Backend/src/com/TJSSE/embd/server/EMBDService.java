package com.TJSSE.embd.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.TJSSE.embd.utility.Locater;

public class EMBDService implements Runnable {
	private Socket clientSocket;
	private BufferedReader in;
	private PrintWriter out;

	public EMBDService(Socket serviceSocket) {
		this.clientSocket = serviceSocket;
	}

	public String execute(String command) {
		String request = "";
		String result;
		try {
			request = command.substring(1, command.length() - 1);
			result = "";
			System.out.println(request);
			String[] commandParts = request.split("|");
			
			//deal with the command
			if (commandParts[0].equals("locate")) {
				String infos = request.substring(2);//"door@1231,42251,3123125|window@3423,5346,1231"
				String[] devide = infos.split("|");
				Map<String, ArrayList<Integer>> levels = new HashMap<String , ArrayList<Integer>>();
				for (String oneSSID : devide) {
					String ssid = oneSSID.split("@")[0];
					String levelString = oneSSID.split("@")[1];
					String[] levelArray = levelString.split(",");
					ArrayList<Integer> levelIntegerList = new ArrayList<Integer>();
					for (String singleLevel : levelArray) {
						levelIntegerList.add(Integer.parseInt(singleLevel));
					}
					levels.put(ssid, levelIntegerList);
				}
				result = Locater.getLocationID(levels);
			}else if (false) {
				//go the other command for future
			}else {
				result = wrongCode(request.substring(2));
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "[]";
		}
		System.out.println("Result:"+result);
		return result;
	}
	
	public static String wrongCode(String command) {
		return "[]";
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			// TODO Auto-generated method stub
			System.out.println("---start Service----");
			in = new BufferedReader(new InputStreamReader(
					clientSocket.getInputStream()));
			out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(
					clientSocket.getOutputStream())), true);
			String request = "";
			while (true) {
				String str = in.readLine();
				request = request + str;
//				System.out.println(request);
				if (request.contains("]")) {
					System.out.println("Request:" + str);
					// out.println("Request:" + str);
					String resultString = execute(request);
					out.println(resultString);
					out.flush();
					break;
				}
			}
			out.close();
			in.close();
			clientSocket.close();

			// Close the connection, but not the server socket
			System.out.println("--end service--");
		} catch (IOException e) {
			System.out.println(e.getMessage());

		}
	}
}
