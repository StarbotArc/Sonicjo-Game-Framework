package me.sjplus.SonicjoGameFramework.net;

import java.io.IOException;
import java.net.*;
import java.util.*;

public class SocketServer implements Runnable {

	private ServerSocket server;
	public List<ClientListener> cListeners = new ArrayList<>();
	private boolean running = false;
	private Thread thread;
	private ConnectionListener connectList;
	
	public SocketServer(int port, String host) {
		
		try {
			this.server = new ServerSocket();
			this.server.bind(new InetSocketAddress(host, port));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.connectList = new ConnectionListener(this.server, this);
		
	}
	
	public void start() {
		
		this.thread = new Thread(this);
		this.thread.start();
		
		this.connectList.start();
		
		this.running = true;
		
	}
	
	public void stop() {
		
		try {
		
			this.thread.join();
	
		} catch (InterruptedException e) {
		
			e.printStackTrace();

		}
		
		this.connectList.stop();
		
		try {
		
			this.server.close();
		
		} catch (IOException e) {
		
			e.printStackTrace();
		
		}
		
		this.running = false;
		
	}
	
	@Override
	public void run() {
		
		while (running) {
			
			for (int i = 0; i < this.cListeners.size(); i++) {
				
				ClientListener client = this.cListeners.get(i);
				
				try {
			
					if (client.in.ready()) {
						
						Packet p = client.readPacket();
						
						if (p != null)
							p.action(this);
						
						else
							System.out.println(p.getData());
						
					}
		
				} catch (IOException e) {
			
					e.printStackTrace();
			
				}
				
			}
			
		}
		
		stop();
		
	}
	
}
