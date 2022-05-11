package me.sjplus.SonicjoGameFramework.net;

import java.util.*;

public interface Packet {

	public static final Map<String, Packet> packetTypes = new HashMap<>();
	
	public void action(SocketClient c);
	public void action(SocketServer s);
	public void parseData(String s);
	public String getData();
	
	public static Packet read(String s) {
	
		Packet p = packetTypes.get(s.substring(0, 2));
		
		if (p != null)
			p.parseData(s.substring(2));
		
		return p;
		
	}
	
}
