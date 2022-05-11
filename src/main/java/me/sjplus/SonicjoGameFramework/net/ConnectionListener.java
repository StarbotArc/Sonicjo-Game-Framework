package me.sjplus.SonicjoGameFramework.net;

import java.io.IOException;
import java.net.*;

public class ConnectionListener implements Runnable {

	private ServerSocket serverSocket;
	private SocketServer sServer;
	private Thread thread;
	private boolean running = false;
	
	public ConnectionListener(ServerSocket serverSocket, SocketServer sServer) {
		
		this.serverSocket = serverSocket;
		this.sServer = sServer;
		
	}

	public void start() {
		
		this.thread = new Thread(this);
		this.thread.start();
		
		this.running = true;
		
	}
	
	public void stop() {
		
		try {
	
			this.thread.join();
	
		} catch (InterruptedException e) {

			e.printStackTrace();
	
		}
		
		this.running = false;
		
	}
	
	@Override
	public void run() {
		
		while (running) {
			
			try {
		
				Socket s = serverSocket.accept();
				sServer.cListeners.add(new ClientListener(s));
				
			} catch (IOException e) {
	
				e.printStackTrace();
		
			}
			
		}
		
	}
	
}
