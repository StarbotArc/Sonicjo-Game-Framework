package me.sjplus.SonicjoGameFramework.net;

import java.io.*;
import java.net.*;

public class ClientListener {

	private Socket socket;
	public BufferedReader in;
	public PrintWriter out;
	
	public ClientListener(Socket s) throws IOException {
		
		this.socket = s;
		this.in = new BufferedReader(new InputStreamReader(s.getInputStream()));
		this.out = new PrintWriter(s.getOutputStream());
		
	}
	
	public String read() {
		
		try {
		
			return in.readLine();
	
		} catch (IOException e) {
	
			e.printStackTrace();
	
		}
		
		return null;
		
	}
	
	public Packet readPacket() {
		
		return Packet.read(read());
		
	}
	
	public void send(String s) {
		
		out.println(s);
		out.flush();
		
	}

	public void sendPacket(Packet p) {
		
		send(p.getData());
		
	}
	
}
