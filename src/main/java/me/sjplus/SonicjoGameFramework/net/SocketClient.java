package me.sjplus.SonicjoGameFramework.net;

import java.io.*;
import java.net.*;

public class SocketClient {
	
	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	
	public SocketClient(int port, String host) {
		
		try {
		
			this.socket = new Socket(host, port);
		
		} catch (IOException e) {
		
			e.printStackTrace();
		
		}
		
	}
	
	public void listen() throws IOException {
		
		if (in.ready()) {
			
			String pData = in.readLine();
			Packet p = Packet.read(pData);
			
			if (p != null)
				p.action(this);

			else
				System.out.println(pData);
			
		}
		
	}

}
